package com.example.springredisopenapi.repositories;

import com.example.springredisopenapi.models.GroupModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface GroupRepository extends CrudRepository<GroupModel, String>,
        QueryByExampleExecutor<GroupModel> {
    
}
