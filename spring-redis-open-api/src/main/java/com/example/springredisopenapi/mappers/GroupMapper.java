package com.example.springredisopenapi.mappers;

import java.util.Collection;
import java.util.List;

import com.example.springredisopenapi.models.GroupModel;
import com.example.springredisopenapi.transferobjects.GroupTO;

import org.mapstruct.Mapper;

@Mapper
public interface GroupMapper {

    GroupTO mapGroupModelToGroupTO(final GroupModel groupModel);

    List<GroupTO> mapGroupModelsToGroupTOs(final Collection<GroupModel> groupModels);
    
}
