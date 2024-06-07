package com.example.springredisopenapi.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.generated.UsersApi;
import com.example.springredisopenapi.generated.model.CreateUser;
import com.example.springredisopenapi.generated.model.ModifyUser;
import com.example.springredisopenapi.generated.model.User;
import com.example.springredisopenapi.generated.model.UsersGet200Response;
import com.example.springredisopenapi.mappers.UserMapper;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.services.GroupService;
import com.example.springredisopenapi.services.UserService;
import com.example.springredisopenapi.utils.GroupUtils;
import com.example.springredisopenapi.utils.StringUtils;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1")
public class UsersController implements UsersApi {
    
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    
    private final UserService userService;
    private final GroupService groupService;

    public UsersController(final UserService userService, final GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @Override
    public ResponseEntity<UsersGet200Response> usersGet(@Valid final String name, @Valid final String email,
            @Valid final String gender) {
        
        final List<UserModel> users;
        if (StringUtils.isNotBlank(name) || StringUtils.isNotBlank(email) || StringUtils.isNotBlank(gender)) {

            final GenderEnum genderEnum = StringUtils.isNotBlank(gender) ? GenderEnum.valueOf(gender) : null;
            users = this.userService.getByParameters(name, email, genderEnum);
        } else {
            users = this.userService.getUsers();
        }

        return new ResponseEntity<>(
                new UsersGet200Response()
                    .total(users.size())
                    .results(
                        this.userMapper.mapUserTOsToUsers(
                            this.userMapper.mapUserModelsToUserTOs(users)  
                        )
                    ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<User> usersPost(@Valid final CreateUser createUser) {
        
        final Set<String> groupIds = !CollectionUtils.isEmpty(createUser.getGroupIds()) ?
                new HashSet<>(createUser.getGroupIds()) : 
                Set.of();
        
        if (!groupIds.isEmpty()) {
            GroupUtils.validateGroupIds(this.groupService.getAllByIds(groupIds), groupIds);
        }
        
        return new ResponseEntity<>(
                this.userMapper.mapUserTOToUser(
                    this.userMapper.mapUserModelToUserTO(
                        this.userService.saveUser(
                                createUser.getName(), createUser.getEmail(), GenderEnum.valueOf(createUser.getGender()), groupIds
                        )
                    )
                ),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<User> usersUserIdGet(final String userId) {
        
        return new ResponseEntity<>(
                this.userMapper.mapUserTOToUser(
                    this.userMapper.mapUserModelToUserTO(
                        this.userService.getById(userId)
                    )
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<User> usersUserIdPut(final String userId, @Valid final ModifyUser modifyUser) {

        return new ResponseEntity<>(
                this.userMapper.mapUserTOToUser(
                    this.userMapper.mapUserModelToUserTO(
                        this.userService.updateById(
                                userId, modifyUser.getName(), modifyUser.getEmail(), GenderEnum.valueOf(modifyUser.getGender())
                        )
                    )
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Void> usersUserIdDelete(final String userId) {
        
        this.userService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }

}
