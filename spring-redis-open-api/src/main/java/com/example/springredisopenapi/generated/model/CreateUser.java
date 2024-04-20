package com.example.springredisopenapi.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Create user model.
 */

@Schema(name = "CreateUser", description = "Create user model.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class CreateUser {

  private String name;

  private String email;

  private String gender;

  @Valid
  private List<String> groupIds;

  public CreateUser name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the user.
   * @return name
  */
  
  @Schema(name = "name", description = "Name of the user.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateUser email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email of the user.
   * @return email
  */
  
  @Schema(name = "email", description = "Email of the user.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateUser gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Gender of the user
   * @return gender
  */
  
  @Schema(name = "gender", description = "Gender of the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public CreateUser groupIds(List<String> groupIds) {
    this.groupIds = groupIds;
    return this;
  }

  public CreateUser addGroupIdsItem(String groupIdsItem) {
    if (this.groupIds == null) {
      this.groupIds = new ArrayList<>();
    }
    this.groupIds.add(groupIdsItem);
    return this;
  }

  /**
   * IDs of the groups
   * @return groupIds
  */
  
  @Schema(name = "groupIds", description = "IDs of the groups", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupIds")
  public List<String> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(List<String> groupIds) {
    this.groupIds = groupIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUser createUser = (CreateUser) o;
    return Objects.equals(this.name, createUser.name) &&
        Objects.equals(this.email, createUser.email) &&
        Objects.equals(this.gender, createUser.gender) &&
        Objects.equals(this.groupIds, createUser.groupIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, gender, groupIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUser {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    groupIds: ").append(toIndentedString(groupIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

