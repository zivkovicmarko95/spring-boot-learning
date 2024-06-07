package com.example.springredisopenapi.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.repositories.GroupRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith({ SpringExtension.class })
class GroupServiceTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private GroupRepository groupRepository;

    private GroupService groupService;

    @BeforeEach
    void before() {
        groupService = new GroupService(this.groupRepository);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.groupRepository);
    }

    @Test
    void getById() {

        final GroupModel groupModel = PODAM_FACTORY.manufacturePojo(GroupModel.class);
        final String groupId = groupModel.getId();

        when(this.groupRepository.findById(groupId)).thenReturn(Optional.of(groupModel));

        final GroupModel result = this.groupService.getById(groupId);

        assertThat(result).isEqualTo(groupModel);

        verify(this.groupRepository).findById(groupId);
    }

    @Test
    void getById_notFound() {

        final String groupId = PODAM_FACTORY.manufacturePojo(String.class);

        when(this.groupRepository.findById(groupId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> groupService.getById(groupId))
                .isExactlyInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("Group with ID %s is not found", groupId));

        verify(this.groupRepository).findById(groupId);
    }

    @Test
    void getAllByIds() {
        
        final Set<String> groupIds = PODAM_FACTORY.manufacturePojo(Set.class, String.class);
        final List<GroupModel> mockGroupModels = PODAM_FACTORY.manufacturePojo(ArrayList.class, GroupModel.class);

        when(this.groupRepository.findAllById(groupIds)).thenReturn(mockGroupModels);

        final List<GroupModel> result = this.groupService.getAllByIds(groupIds);

        assertThat(result).containsAll(mockGroupModels);

        verify(this.groupRepository).findAllById(groupIds);
    }

    @Test
    void getByParameters() {
        
        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final List<GroupModel> mockGroupModels = PODAM_FACTORY.manufacturePojo(List.class, GroupModel.class);
        final GroupModel groupModel = new GroupModel().setName(name);
        
        when(this.groupRepository.findAll(Example.of(groupModel)))
                .thenReturn(mockGroupModels);

        final List<GroupModel> result = this.groupService.getByParameters(name);

        assertThat(result).containsAll(mockGroupModels);

        verify(this.groupRepository).findAll(Example.of(groupModel));
    }

    @Test
    void saveGroup() {
        
        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final GroupModel mockGroupModel = PODAM_FACTORY.manufacturePojo(GroupModel.class);
        
        when(groupRepository.save(any())).thenReturn(mockGroupModel);

        final GroupModel result = this.groupService.saveGroup(name);

        assertThat(result).isEqualTo(mockGroupModel);

        verify(groupRepository).save(any());
    }

    @Test
    void updateById() {

        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final GroupModel mockGroupModel = PODAM_FACTORY.manufacturePojo(GroupModel.class);
        final String id = mockGroupModel.getId();

        when(this.groupRepository.findById(id)).thenReturn(Optional.of(mockGroupModel));
        when(this.groupRepository.save(any())).thenReturn(mockGroupModel);

        final GroupModel result = this.groupService.updateById(id, name);

        assertThat(result).isEqualTo(mockGroupModel);

        verify(this.groupRepository).findById(id);
        verify(this.groupRepository).save(any());
    }

    @Test
    void updateById_notFound() {

        final String id = PODAM_FACTORY.manufacturePojo(String.class);
        final String name = PODAM_FACTORY.manufacturePojo(String.class);

        when(this.groupRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.groupService.updateById(id, name))
                .isExactlyInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("Group with ID %s is not found", id));

        verify(this.groupRepository).findById(id);
        verify(this.groupRepository, never()).save(any());
    }

    @Test
    void deleteById() {

        final String id = PODAM_FACTORY.manufacturePojo(String.class);

        this.groupService.deleteById(id);

        verify(this.groupRepository).deleteById(id);
    }

}
