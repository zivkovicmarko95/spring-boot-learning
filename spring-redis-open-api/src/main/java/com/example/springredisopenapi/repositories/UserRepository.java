package com.example.springredisopenapi.repositories;

import com.example.springredisopenapi.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserRepository extends CrudRepository<UserModel, String>,
        QueryByExampleExecutor<UserModel> {
    
}
