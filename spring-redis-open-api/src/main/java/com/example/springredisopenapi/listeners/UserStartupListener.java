package com.example.springredisopenapi.listeners;

import java.util.Set;

import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.services.GroupService;
import com.example.springredisopenapi.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserStartupListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupStartupListener.class);

    private final UserService userService;
    private final GroupService groupService;

    public UserStartupListener(final UserService userService, final GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {

        final GroupModel groupModel1 = this.groupService.saveGroup("Test Group");

        LOGGER.info("Saved groups {}", groupModel1);

        final UserModel userModel1 = this.userService.saveUser(
                "Test Name #1", "email1@gmail.com", GenderEnum.MALE, Set.of(groupModel1.getId())
        );

        final UserModel userModel2 = this.userService.saveUser(
                "Test Name #2", "email2@gmail.com", GenderEnum.FEMALE, Set.of(groupModel1.getId())
        );

        LOGGER.info("Created users {}, {}", userModel1, userModel2);
    }
    
}
