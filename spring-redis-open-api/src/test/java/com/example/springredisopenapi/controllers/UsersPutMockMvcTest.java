package com.example.springredisopenapi.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springredisopenapi.constants.ApiTestConstants;
import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.exceptions.handlers.GlobalExceptionHandler;
import com.example.springredisopenapi.generated.model.ModifyUser;
import com.example.springredisopenapi.generated.model.User;
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
class UsersPutMockMvcTest {
    
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
        verifyNoMoreInteractions(this.userService);
        verifyNoInteractions(this.groupService);
    }

    @ParameterizedTest
    @EnumSource(GenderEnum.class)
    void usersUserIdPut(final GenderEnum gender) throws Exception {

        final ModifyUser modifyUser = PODAM_FACTORY.manufacturePojo(ModifyUser.class)
                .gender(gender.name())
                .email("test@test.com");

        final String userId = PODAM_FACTORY.manufacturePojo(String.class);
        final String name = modifyUser.getName();
        final String email = modifyUser.getEmail();

        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);

        when(this.userService.updateById(userId, name, email, gender)).thenReturn(userModel);

        final ResultActions resultActions = this.mockMvc.perform(put(ApiTestConstants.USERS_WITH_ID, userId)
                    .content(this.objectMapper.writeValueAsString(modifyUser))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        final User result = this.objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                User.class
        );

        verifyUser(result, userModel);

        verify(this.userService).updateById(userId, name, email, gender);
    }

    @Test
    void usersUserIdPut_invalidGender() throws Exception {

        final String userId = PODAM_FACTORY.manufacturePojo(String.class);
        final ModifyUser modifyUser = PODAM_FACTORY.manufacturePojo(ModifyUser.class)
                .gender("INVALID_GENDER");

        this.mockMvc.perform(put(ApiTestConstants.USERS_WITH_ID, userId)
                    .content(this.objectMapper.writeValueAsString(modifyUser))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void usersUserIdPut_noRequestBody() throws Exception {

        final String userId = PODAM_FACTORY.manufacturePojo(String.class);

        this.mockMvc.perform(put(ApiTestConstants.USERS_WITH_ID, userId)
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
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
