package com.example.springredisopenapi.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.services.GroupService;
import com.example.springredisopenapi.services.UserService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
class UserStartupListenerTest {
    
    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private UserService userService;

    @MockBean
    private GroupService groupService;

    private UserStartupListener userStartupListener;

    @BeforeEach
    void before() {
        userStartupListener = new UserStartupListener(this.userService, this.groupService);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.userService, this.groupService);
    }

    @Test
    void onApplicationReady() {

        final GroupModel groupModel = PODAM_FACTORY.manufacturePojo(GroupModel.class);
        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);

        when(this.groupService.saveGroup(any())).thenReturn(groupModel);
        when(this.userService.saveUser(any(), any(), any(), any())).thenReturn(userModel);

        this.userStartupListener.onApplicationReady();

        verify(this.groupService).saveGroup(any());
        verify(this.userService, times(2)).saveUser(any(), any(), any(), any());
    }

}
