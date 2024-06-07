package com.example.springredisopenapi.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.springredisopenapi.constants.ApiTestConstants;
import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.exceptions.handlers.GlobalExceptionHandler;
import com.example.springredisopenapi.generated.model.CreateUser;
import com.example.springredisopenapi.generated.model.User;
import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.services.GroupService;
import com.example.springredisopenapi.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {
    GlobalExceptionHandler.class, UsersController.class
})
class UsersPostMockMvcTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private UserService userService;

    @MockBean
    private GroupService groupService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.userService, this.groupService);
    }

    @ParameterizedTest
    @EnumSource(GenderEnum.class)
    void usersPost(final GenderEnum genderEnum) throws Exception {

        final List<GroupModel> groupModels = PODAM_FACTORY.manufacturePojo(List.class, GroupModel.class);
        final List<String> groupIdsList = groupModels.stream()
                .map(GroupModel::getId)
                .toList();

        final CreateUser createUser = PODAM_FACTORY.manufacturePojo(CreateUser.class)
                .gender(genderEnum.name())
                .email("email@gmail.com")
                .groupIds(groupIdsList);

        final String name = createUser.getName();
        final String email = createUser.getEmail();
        final GenderEnum gender = GenderEnum.valueOf(createUser.getGender());
        final Set<String> groupIds = new HashSet<>(groupIdsList);

        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);

        when(this.groupService.getAllByIds(groupIds)).thenReturn(groupModels);
        when(this.userService.saveUser(name, email, gender, groupIds)).thenReturn(userModel);

        final ResultActions resultActions = this.mockMvc.perform(post(ApiTestConstants.USERS)
                    .content(this.objectMapper.writeValueAsString(createUser))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        final User result = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                User.class
        );

        verifyUser(result, userModel);

        verify(this.groupService).getAllByIds(groupIds);
        verify(this.userService).saveUser(name, email, gender, groupIds);
    }

    @Test
    void usersPost_invalidGender() throws Exception {

        final CreateUser createUser = PODAM_FACTORY.manufacturePojo(CreateUser.class)
                .gender("INVALID_GENDER");

        this.mockMvc.perform(post(ApiTestConstants.USERS)
                    .content(this.objectMapper.writeValueAsString(createUser))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void usersPost_noRequestBody() throws Exception {

        this.mockMvc.perform(post(ApiTestConstants.USERS)
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @EnumSource(GenderEnum.class)
    void usersPost_emptyGroupIds(final GenderEnum genderEnum) throws Exception {

        final CreateUser createUser = PODAM_FACTORY.manufacturePojo(CreateUser.class)
                .gender(genderEnum.name())
                .email("test@test.com")
                .groupIds(List.of());

        final String name = createUser.getName();
        final String email = createUser.getEmail();
        final GenderEnum gender = GenderEnum.valueOf(createUser.getGender());
        final Set<String> groupIds = new HashSet<>();

        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);

        when(this.userService.saveUser(name, email, gender, groupIds)).thenReturn(userModel);

        final ResultActions resultActions = this.mockMvc.perform(post(ApiTestConstants.USERS)
                    .content(this.objectMapper.writeValueAsString(createUser))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        final User result = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                User.class
        );

        verifyUser(result, userModel);

        verify(this.userService).saveUser(name, email, gender, groupIds);
    }

    private void verifyUser(final User result, final UserModel user) {

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(user.getId());
        assertThat(result.getName()).isEqualTo(user.getName());
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getGender()).isEqualTo(user.getGender().name());
        assertThat(result.getGroupIds()).containsAll(user.getGroupIds());
    }
    
}
