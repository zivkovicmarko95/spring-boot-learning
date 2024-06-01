package com.example.springredisopenapi.services;

import java.util.List;
import java.util.Set;
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
     * Fetches a group by the provided ID
     * 
     * @param id ID of the group
     * @return Found {@link GroupModel}
     * @throws ResourceNotFoundException if the group is not found
     */
    public GroupModel getById(final String id) {

        return this.groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    String.format("Group with ID %s is not found", id)
                ));
    }

    /**
     * Retrieves all {@link GroupModel} entities with the given set of IDs.
     * 
     * <p>This method fetches all {@link GroupModel} entities corresponding to the provided IDs
     * in a single database query, and returns them as a List. If no {@link GroupModel} are
     * found for the given IDs, an empty {@link List} is returned.
     * 
     * @param ids the set of IDs for which to retrieve the {@link GroupModel} entities
     * @return a {@link List} of {@link GroupModel} entities with the given IDs, or an empty
     *         {@link List} if no entities are found
     */
    public List<GroupModel> getAllByIds(final Set<String> ids) {

        final Iterable<GroupModel> groupModels = this.groupRepository.findAllById(ids);

        return StreamSupport.stream(groupModels.spliterator(),false)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all groups matching the provided parameters
     * 
     * @param name name of the group
     * @return {@link List} of found {@link GroupModel}
     */
    public List<GroupModel> getByParameters(final String name) {

        final GroupModel groupModel = new GroupModel().setName(name);

        final Iterable<GroupModel> groupModels = this.groupRepository.findAll(Example.of(groupModel));

        return StreamSupport.stream(groupModels.spliterator(),false)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new group with the provided parameters
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
     * Updates the group with the provided group ID
     * 
     * @param id   Id of the group
     * @param name Name of the group to be updated
     * @return Updated {@link GroupModel}
     * @throws ResourceNotFoundException if the group is not found
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
     * Deletes the group with the provided group ID
     * 
     * @param id ID of the group to be deleted
     */
    public void deleteById(final String id) {

        this.groupRepository.deleteById(id);

        LOGGER.info("Group with ID {} is deleted ... OK", id);
    }
    
}
