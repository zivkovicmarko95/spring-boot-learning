package com.example.springredisopenapi.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.transferobjects.GroupTO;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

class GroupMapperTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    private final GroupMapper groupMapper = Mappers.getMapper(GroupMapper.class);

    @Test
    void mapGroupModelToGroupTO() {

        final GroupModel groupModel = PODAM_FACTORY.manufacturePojo(GroupModel.class);

        final GroupTO result = this.groupMapper.mapGroupModelToGroupTO(groupModel);

        verifyGroupTO(result, groupModel);
    }

    @Test
    void mapGroupModelsToGroupTOs() {

        final Collection<GroupModel> groupModels = PODAM_FACTORY.manufacturePojo(List.class, GroupModel.class);

        final List<GroupTO> results = this.groupMapper.mapGroupModelsToGroupTOs(groupModels);

        results.forEach(result -> {
            final GroupModel groupModel = groupModels.stream()
                    .filter(group -> group.getId().equals(result.id()))
                    .findFirst()
                    .get();

            verifyGroupTO(result, groupModel);
        });
    }

    private void verifyGroupTO(final GroupTO result, final GroupModel groupModel) {
        
        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo(groupModel.getId());
        assertThat(result.name()).isEqualTo(groupModel.getName());
    }
    
}
