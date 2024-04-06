package com.example.springredisopenapi.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getById(final String id) {

        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    String.format("User with ID %s is not found", id)
                ));
    }

    public List<UserModel> getByParameters(final String name, final String email, final GenderEnum gender) {

        final UserModel userModel = new UserModel().setName(name)
                .setEmail(email)
                .setGender(gender);

        final Iterable<UserModel> userModels = this.userRepository.findAll(Example.of(userModel));

        return StreamSupport.stream(userModels.spliterator(),false)
                .collect(Collectors.toList());
    }

    public UserModel saveUser(final String name, final String email, final GenderEnum gender,
            final Set<String> groupIds) {

        LOGGER.info("Creating new user with name {} and email {}", name, email);

        return this.userRepository.save(
                new UserModel(name, email, gender, groupIds)
        );
    }

    public UserModel updateById(final String id, final String name, final String email, final GenderEnum gender) {

        final UserModel userModel = this.getById(id);

        LOGGER.info(
                "Updating user by ID {} with parameters name {}, email {} and gender {}",
                id, name, email, gender
        );

        return this.userRepository.save(
                userModel.setName(name)
                        .setEmail(email)
                        .setGender(gender)
        );
    }
    
    public void deleteById(final String id) {

        this.userRepository.deleteById(id);

        LOGGER.info("User with ID {} is deleted ... OK", id);
    }

}
