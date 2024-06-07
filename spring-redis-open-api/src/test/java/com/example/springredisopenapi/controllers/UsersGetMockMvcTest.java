package com.example.springredisopenapi.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.example.springredisopenapi.constants.ApiTestConstants;
import com.example.springredisopenapi.constants.QueryParamConstants;
import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.exceptions.handlers.GlobalExceptionHandler;
import com.example.springredisopenapi.generated.model.User;
import com.example.springredisopenapi.generated.model.UsersGet200Response;
import com.example.springredisopenapi.mappers.UserMapper;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.services.GroupService;
import com.example.springredisopenapi.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class UsersGetMockMvcTest {
  
    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    private static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

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
        verifyNoMoreInteractions(this.userService);
        verifyNoInteractions(this.groupService);
    }

    @Test
    void usersGet_withParameters() throws Exception {

        final List<UserModel> userModels = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);

        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final String email = PODAM_FACTORY.manufacturePojo(String.class);
        final String gender = GenderEnum.MALE.name();

        when(this.userService.getByParameters(name, email, GenderEnum.MALE)).thenReturn(userModels);

        final ResultActions resultActions = this.mockMvc.perform(get(ApiTestConstants.USERS)
                    .queryParam(QueryParamConstants.NAME, name)
                    .queryParam(QueryParamConstants.EMAIL, email)
                    .queryParam(QueryParamConstants.GENDER, gender))
                .andExpect(status().isOk());

        final UsersGet200Response results = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                UsersGet200Response.class
        );

        final List<User> users = USER_MAPPER.mapUserTOsToUsers(
            USER_MAPPER.mapUserModelsToUserTOs(userModels)
        );

        assertThat(results).isNotNull();
        assertThat(results.getResults()).containsAll(users);

        verify(this.userService).getByParameters(name, email, GenderEnum.MALE);
    }

    @Test
    void usersGet_withNameParameter() throws Exception {
        final List<UserModel> userModels = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);
        final String name = PODAM_FACTORY.manufacturePojo(String.class);

        when(this.userService.getByParameters(name, null, null)).thenReturn(userModels);

        final ResultActions resultActions = this.mockMvc.perform(get(ApiTestConstants.USERS)
                    .queryParam(QueryParamConstants.NAME, name))
                .andExpect(status().isOk());

        final UsersGet200Response results = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                UsersGet200Response.class
        );

        final List<User> users = USER_MAPPER.mapUserTOsToUsers(
            USER_MAPPER.mapUserModelsToUserTOs(userModels)
        );

        assertThat(results).isNotNull();
        assertThat(results.getResults()).containsAll(users);

        verify(this.userService).getByParameters(name, null, null);
    }

    @Test
    void usersGet_withNameAndEmailParameters() throws Exception {
        final List<UserModel> userModels = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);
        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final String email = PODAM_FACTORY.manufacturePojo(String.class);

        when(this.userService.getByParameters(name, email, null)).thenReturn(userModels);

        final ResultActions resultActions = this.mockMvc.perform(get(ApiTestConstants.USERS)
                    .queryParam(QueryParamConstants.NAME, name)
                    .queryParam(QueryParamConstants.EMAIL, email))
                .andExpect(status().isOk());

        final UsersGet200Response results = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                UsersGet200Response.class
        );

        final List<User> users = USER_MAPPER.mapUserTOsToUsers(
            USER_MAPPER.mapUserModelsToUserTOs(userModels)
        );

        assertThat(results).isNotNull();
        assertThat(results.getResults()).containsAll(users);

        verify(this.userService).getByParameters(name, email, null);
    }

    @Test
    void usersGet_withoutParameters() throws Exception {
        final List<UserModel> userModels = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);

        when(this.userService.getUsers()).thenReturn(userModels);

        final ResultActions resultActions = this.mockMvc.perform(get(ApiTestConstants.USERS))
                .andExpect(status().isOk());

        final UsersGet200Response results = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                UsersGet200Response.class
        );

        final List<User> users = USER_MAPPER.mapUserTOsToUsers(
            USER_MAPPER.mapUserModelsToUserTOs(userModels)
        );

        assertThat(results).isNotNull();
        assertThat(results.getResults()).containsAll(users);

        verify(this.userService).getUsers();
    }

    @Test
    void usersUserIdGet() throws Exception {
        
        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);
        final String userId = userModel.getId();

        when(this.userService.getById(userId)).thenReturn(userModel);

        final ResultActions resultActions = this.mockMvc.perform(get(ApiTestConstants.USERS_WITH_ID, userId))
                .andExpect(status().isOk());

        final User result = this.objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), User.class);

        assertThat(result).isNotNull()
                .isEqualTo(USER_MAPPER.mapUserTOToUser(
                    USER_MAPPER.mapUserModelToUserTO(userModel)
                ));

        verify(this.userService).getById(userId);
    }

}
