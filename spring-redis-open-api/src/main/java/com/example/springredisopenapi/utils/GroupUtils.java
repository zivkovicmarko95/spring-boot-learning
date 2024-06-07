package com.example.springredisopenapi.utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.GroupModel;

import org.springframework.util.CollectionUtils;

public class GroupUtils {

    private GroupUtils() {

    }
    
    /**
     * Validates that all provided group IDs exist among the given {@link GroupModel} entities.
     *
     * <p>This method checks if all IDs in the provided set of groupIds exist in the list of
     * {@link GroupModel} entities. If any of the IDs are not found, a {@link ResourceNotFoundException}
     * is thrown with a message indicating the missing IDs.
     *
     * @param groupModels the {@link List} of {@link GroupModel} entities to validate against
     * @param groupIds the set of group IDs to be validated
     * @throws ResourceNotFoundException if any group IDs are not found in the list of {@link GroupModel} entities
     */
    public static void validateGroupIds(final List<GroupModel> groupModels, final Set<String> groupIds) {
        
        if(CollectionUtils.isEmpty(groupIds)) {
            return;
        }

        final Set<String> existingGroupIds = groupModels.stream()
                .map(GroupModel::getId)
                .collect(Collectors.toSet());

        final List<String> missingGroupIds = groupIds.stream()
                .filter(id -> !existingGroupIds.contains(id))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(missingGroupIds)) {
            throw new ResourceNotFoundException(
                String.format("Group IDs %s do not exist.", missingGroupIds)
            );
        }
    }

}
