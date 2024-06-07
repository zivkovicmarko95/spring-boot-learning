package com.example.springredisopenapi.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springredisopenapi.constants.ApiTestConstants;
import com.example.springredisopenapi.exceptions.handlers.GlobalExceptionHandler;
import com.example.springredisopenapi.services.GroupService;
import com.example.springredisopenapi.services.UserService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {
    GlobalExceptionHandler.class, UsersController.class
})
class UsersDeleteMockMvcTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private UserService userService;

    @MockBean
    private GroupService groupService;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.userService);
        verifyNoInteractions(this.groupService);
    }

    @Test
    void usersUserIdDelete() throws Exception {

        final String userId = PODAM_FACTORY.manufacturePojo(String.class);

        this.mockMvc.perform(delete(ApiTestConstants.USERS_WITH_ID, userId))
                .andExpect(status().isNoContent());

        verify(this.userService).deleteById(userId);
    }
    
}
