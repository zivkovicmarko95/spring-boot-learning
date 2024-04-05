package com.example.springredisopenapi.models;

import com.example.springredisopenapi.enums.GenderEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@RedisHash("user")
public class UserModel {

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String email;
    private GenderEnum gender;

    @Reference
    private Set<String> groupIds = new HashSet<>();

    public UserModel() {

    }

    public UserModel(final String name, final String email, final GenderEnum gender,
            final Set<String> groupIds) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.groupIds = groupIds;
    }

    public String getId() {
        return this.id;
    }

    public UserModel setId(final String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public UserModel setName(final String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public UserModel setEmail(final String email) {
        this.email = email;
        return this;
    }

    public GenderEnum getGender() {
        return this.gender;
    }

    public UserModel setGender(final GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public Set<String> getGroupIds() {
        return this.groupIds;
    }

    public UserModel setGroupIds(final Set<String> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) &&
                Objects.equals(name, userModel.name) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(gender, userModel.gender) &&
                Objects.equals(groupIds, userModel.groupIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, gender, groupIds);
    }
    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", gender='" + getGender() + "'" +
            ", groupIds='" + getGroupIds() + "'" +
            "}";
    }

}
