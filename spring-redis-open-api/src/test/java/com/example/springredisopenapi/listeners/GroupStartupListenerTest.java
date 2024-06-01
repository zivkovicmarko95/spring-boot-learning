package com.example.springredisopenapi.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.services.GroupService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
class GroupStartupListenerTest {
    
    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private GroupService groupService;

    private GroupStartupListener groupStartupListener;

    @BeforeEach
    void before() {
        groupStartupListener = new GroupStartupListener(this.groupService);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.groupService);
    }

    @Test
    void onApplicationReady() {

        final GroupModel groupModel = PODAM_FACTORY.manufacturePojo(GroupModel.class);

        when(this.groupService.saveGroup(any())).thenReturn(groupModel);

        this.groupStartupListener.onApplicationReady();

        verify(this.groupService, times(2)).saveGroup(any());
    }

}
