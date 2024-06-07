package com.example.springredisopenapi.listeners;

import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.services.GroupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GroupStartupListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupStartupListener.class);

    private final GroupService groupService;

    public GroupStartupListener(final GroupService groupService) {
        this.groupService = groupService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {

        final GroupModel groupModel1 = this.groupService.saveGroup("Test Group #1");
        final GroupModel groupModel2 = this.groupService.saveGroup("Test Group #2");

        LOGGER.info("Saved groups {}, {}", groupModel1, groupModel2);
    }
    
}
