package com.example.springredisopenapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.GroupModel;

import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

class GroupUtilsTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @Test
    void validateGroupIds_noGroupIdsProvided() {
        final List<GroupModel> groupModels = PODAM_FACTORY.manufacturePojo(ArrayList.class, GroupModel.class);

        GroupUtils.validateGroupIds(groupModels, Set.of());
    }

    @Test
    void validateGroupIds() {
        final List<GroupModel> groupModels = PODAM_FACTORY.manufacturePojo(ArrayList.class, GroupModel.class);

        final Set<String> existingIds = groupModels.stream()
                .map(GroupModel::getId)
                .collect(Collectors.toSet());

        GroupUtils.validateGroupIds(groupModels, existingIds);
    }

    @Test
    void validateGroupIds_failure() {

        final List<GroupModel> groupModels = PODAM_FACTORY.manufacturePojo(ArrayList.class, GroupModel.class);

        final Set<String> groupIds = PODAM_FACTORY.manufacturePojo(Set.class, String.class);

        assertThatThrownBy(() -> GroupUtils.validateGroupIds(groupModels, groupIds))
                .isExactlyInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining(String.format("Group IDs %s do not exist.", groupIds));
    }
    
}
