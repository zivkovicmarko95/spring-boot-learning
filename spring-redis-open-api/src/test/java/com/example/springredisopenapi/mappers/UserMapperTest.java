package com.example.springredisopenapi.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import com.example.springredisopenapi.generated.model.User;
import com.example.springredisopenapi.models.UserModel;
import com.example.springredisopenapi.transferobjects.UserTO;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

class UserMapperTest {
    
    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void mapUserModelToUserTO() {

        final UserModel userModel = PODAM_FACTORY.manufacturePojo(UserModel.class);

        final UserTO result = this.userMapper.mapUserModelToUserTO(userModel);

        verifyUserTO(result, userModel);
    }

    @Test
    void mapUserModelsToUserTOs() {

        final Collection<UserModel> userModels = PODAM_FACTORY.manufacturePojo(List.class, UserModel.class);

        final List<UserTO> results = this.userMapper.mapUserModelsToUserTOs(userModels);

        results.forEach(result -> {
            final UserModel userModel = userModels.stream()
                    .filter(user -> user.getId().equals(result.id()))
                    .findFirst()
                    .get();

            verifyUserTO(result, userModel);
        });
    }

    @Test
    void mapUserTOToUser() {

        final UserTO userTO = PODAM_FACTORY.manufacturePojo(UserTO.class);

        final User result = this.userMapper.mapUserTOToUser(userTO);

        verifyUser(result, userTO);
    }

    @Test
    void mapUserTOsToUsers() {

        final Collection<UserTO> userTOs = PODAM_FACTORY.manufacturePojo(List.class, UserTO.class);

        final List<User> results = this.userMapper.mapUserTOsToUsers(userTOs);

        results.forEach(result -> {
            final UserTO userTO = userTOs.stream()
                    .filter(user -> user.id().toString().equals(result.getId()))
                    .findFirst()
                    .get();

            verifyUser(result, userTO);
        });
    }

    private void verifyUserTO(final UserTO result, final UserModel userModel) {
        
        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo(userModel.getId());
        assertThat(result.name()).isEqualTo(userModel.getName());
        assertThat(result.email()).isEqualTo(userModel.getEmail());
        assertThat(result.gender()).isEqualTo(userModel.getGender());
        assertThat(result.groupIds()).containsAll(userModel.getGroupIds());
    }

    private void verifyUser(final User result, final UserTO userTO) {
        
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(userTO.id());
        assertThat(result.getName()).isEqualTo(userTO.name());
        assertThat(result.getEmail()).isEqualTo(userTO.email());
        assertThat(result.getGender()).isEqualTo(userTO.gender().name());
        assertThat(result.getGroupIds()).containsAll(userTO.groupIds());
    }

}
