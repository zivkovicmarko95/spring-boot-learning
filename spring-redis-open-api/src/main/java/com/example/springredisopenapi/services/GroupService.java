package com.example.springredisopenapi.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.repositories.GroupRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupService.class);

    private final GroupRepository groupRepository;

    public GroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /**
     * Fetch group by provided ID
     * 
     * @param id ID of the group
     * @return Found {@link GroupModel}
     * @throws ResourceNotFoundException If not found
     */
    public GroupModel getById(final String id) {

        return this.groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    String.format("Group with ID %s is not found", id)
                ));
    }

    /**
     * Get all the groups by provided parameters
     * 
     * @param name Name of the group
     * @return List of found {@link GroupModel}
     */
    public List<GroupModel> getByParameters(final String name) {

        final GroupModel groupModel = new GroupModel().setName(name);

        final Iterable<GroupModel> groupModels = this.groupRepository.findAll(Example.of(groupModel));

        return StreamSupport.stream(groupModels.spliterator(),false)
                .collect(Collectors.toList());
    }

    /**
     * Create new group
     * 
     * @param name Name of the group
     * @return Created {@link GroupModel}
     */
    public GroupModel saveGroup(final String name) {

        LOGGER.info("Creating new group with name {}", name);

        return this.groupRepository.save(
                new GroupModel(name)
        );
    }

    /**
     * Update the group by provided group ID
     * 
     * @param id   Id of the group
     * @param name Name of the group to be updated
     * @return Updated {@link GroupModel}
     * @throws ResourceNotFoundException If not found
     */
    public GroupModel updateById(final String id, final String name) {

        final GroupModel groupModel = this.getById(id);

        LOGGER.info(
                "Updating group by ID {} with parameters name {}",
                id, name
        );

        return this.groupRepository.save(
                groupModel.setName(name)
        );
    }
    
    /**
     * Delete group by provide group ID
     * 
     * @param id ID of the group to be deleted
     */
    public void deleteById(final String id) {

        this.groupRepository.deleteById(id);

        LOGGER.info("Group with ID {} is deleted ... OK", id);
    }
    
}
