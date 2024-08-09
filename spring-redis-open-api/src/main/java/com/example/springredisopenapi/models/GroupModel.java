package com.example.springredisopenapi.models;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("group")
public class GroupModel {
    
    @Id
    private String id;

    @Indexed
    private String name;

    public GroupModel() {
    }

    public GroupModel(final String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public GroupModel setId(final String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public GroupModel setName(final String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GroupModel)) {
            return false;
        }
        GroupModel groupModel = (GroupModel) o;
        return Objects.equals(id, groupModel.id) &&
                Objects.equals(name, groupModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }    

}
