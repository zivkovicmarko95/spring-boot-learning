package com.example.springredisopenapi.services;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Fetches a user by the provided ID
     * 
     * @param id ID of the user
     * @return Found {@link UserModel}
     * @throws ResourceNotFoundException if the user is not found
     */
    public UserModel getById(final String id) {

        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    String.format("User with ID %s is not found", id)
                ));
    }

    /**
     * Finds all the users
     * 
     * @return List of found {@link UserModel}
     */
    public List<UserModel> getUsers() {
        
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .toList();
    }

    /**
     * Finds all users matching the provided parameters
     * 
     * @param name   Name of the user
     * @param email  Email of the user
     * @param gender Gender of the user
     * @return List of found {@link UserModel}
     */
    public List<UserModel> getByParameters(@Nullable final String name, @Nullable final String email,
                                        @Nullable final GenderEnum gender) {

        final UserModel userModel = new UserModel().setName(name)
                .setEmail(email)
                .setGender(gender);

        final Iterable<UserModel> userModels = this.userRepository.findAll(Example.of(userModel));

        return StreamSupport.stream(userModels.spliterator(),false)
                .toList();
    }

    /**
     * Saves a new user with the provided parameters
     * 
     * @param name     Name of the user
     * @param email    Email of the user
     * @param gender   Gender of the user
     * @param groupIds IDs of the groups the user belongs to
     * @return Created new {@link UserModel}
     */
    public UserModel saveUser(final String name, final String email, final GenderEnum gender,
            final Set<String> groupIds) {

        LOGGER.info("Creating new user with name {} and email {}", name, email);

        return this.userRepository.save(
                new UserModel(name, email, gender, groupIds)
        );
    }

    /**
     * Updates the user with the provided ID and details
     * 
     * @param id     ID of the user
     * @param name   Name of the user to be updated
     * @param email  Email of the user to be updated
     * @param gender Gender of the user to be updated
     * @return Updated {@link UserModel}
     * @throws ResourceNotFoundException if the user is not found
     */
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
    
    /**
     * Deletes the user with the provided ID
     * 
     * @param id ID of the user to be deleted
     */
    public void deleteById(final String id) {

        this.userRepository.deleteById(id);

        LOGGER.info("User with ID {} is deleted ... OK", id);
    }

}
