package com.example.springredisopenapi.mappers;

import java.util.Collection;
import java.util.List;

import com.example.springredisopenapi.generated.model.User;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.transferobjects.UserTO;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserTO mapUserModelToUserTO(final UserModel userModel);

    List<UserTO> mapUserModelsToUserTOs(final Collection<UserModel> userModels);

    User mapUserTOToUser(final UserTO userTO);

    List<User> mapUserTOsToUsers(final Collection<UserTO> userTOs);
    
}
