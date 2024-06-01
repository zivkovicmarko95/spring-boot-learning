package com.example.springredisopenapi.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.example.springredisopenapi.enums.GenderEnum;
import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.repositories.UserRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith({ SpringExtension.class })
class UserServiceTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void before() {
        userService = new UserService(this.userRepository);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.userRepository);
    }

    @Test
    void getById() {
        
        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);
        final String id = userModel.getId();

        when(this.userRepository.findById(id)).thenReturn(Optional.of(userModel));

        final UserModel result = userService.getById(id);

        assertThat(result).isEqualTo(userModel);

        verify(this.userRepository).findById(id);
    }

    @Test
    void getById_notFound() {

        final String id = PODAM_FACTORY.manufacturePojo(String.class);

        when(this.userRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.getById(id))
                .isExactlyInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("User with ID %s is not found", id));

        verify(this.userRepository).findById(id);
    }

    @Test
    void getUsers() {
        
        final List<UserModel> mockUsers = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);

        when(this.userRepository.findAll()).thenReturn(mockUsers);

        final List<UserModel> result = userService.getUsers();

        assertThat(result).containsAll(mockUsers);

        verify(this.userRepository).findAll();
    }

    @ParameterizedTest
    @MethodSource("parametersProvider")
    void getByParameters(final String name, final String email, final GenderEnum gender) {
        
        final List<UserModel> mockUsers = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);

        when(this.userRepository.findAll(any())).thenReturn(mockUsers);

        final List<UserModel> result = userService.getByParameters(name, email, gender);

        assertThat(result).isEqualTo(mockUsers);

        verify(this.userRepository).findAll(any());
    }

    @Test
    void saveUser() {
        
        final UserModel mockUser = PODAM_FACTORY.manufacturePojo(UserModel.class);
        final String name = mockUser.getName();
        final String email = mockUser.getEmail();
        final GenderEnum gender = mockUser.getGender();
        final Set<String> groupIds = mockUser.getGroupIds();
        
        when(this.userRepository.save(any(UserModel.class))).thenReturn(mockUser);

        final UserModel savedUser = userService.saveUser(name, email, gender, groupIds);

        assertThat(savedUser).isNotNull()
                .isEqualTo(mockUser);
        
        verify(this.userRepository).save(any(UserModel.class));
    }

    @Test
    void updateById() {
        
        final UserModel mockUser = PODAM_FACTORY.manufacturePojo(UserModel.class);
        final String userId = mockUser.getId();

        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final String email = PODAM_FACTORY.manufacturePojo(String.class);
        final GenderEnum gender = PODAM_FACTORY.manufacturePojo(GenderEnum.class);
        
        when(this.userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(this.userRepository.save(any(UserModel.class))).thenReturn(mockUser);
        
        final UserModel updatedUser = userService.updateById(userId, name, email, gender);

        assertThat(updatedUser).isNotNull()
                .isEqualTo(mockUser);

        verify(this.userRepository).findById(userId);
        verify(this.userRepository).save(any(UserModel.class));
    }

    @Test
    void updateById_notFound() {
        
        final String userId = PODAM_FACTORY.manufacturePojo(String.class);
        final String name = PODAM_FACTORY.manufacturePojo(String.class);
        final String email = PODAM_FACTORY.manufacturePojo(String.class);
        final GenderEnum gender = PODAM_FACTORY.manufacturePojo(GenderEnum.class);

        when(this.userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.userService.updateById(userId, name, email, gender))
                .isExactlyInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("User with ID %s is not found", userId));

        verify(this.userRepository).findById(userId);
        verify(this.userRepository, never()).save(any(UserModel.class));
    }

    @Test
    void deleteById() {

        final String userId = PODAM_FACTORY.manufacturePojo(String.class);

        this.userService.deleteById(userId);

        verify(this.userRepository).deleteById(userId);
    }

    private static Stream<Object[]> parametersProvider() {

        return Stream.of(
                new Object[]{ PODAM_FACTORY.manufacturePojo(String.class), null, GenderEnum.MALE },
                new Object[]{ null, PODAM_FACTORY.manufacturePojo(String.class), null },
                new Object[]{ PODAM_FACTORY.manufacturePojo(String.class), PODAM_FACTORY.manufacturePojo(String.class), GenderEnum.FEMALE },
                new Object[]{ null, null, null }
        );
    }
    
}
