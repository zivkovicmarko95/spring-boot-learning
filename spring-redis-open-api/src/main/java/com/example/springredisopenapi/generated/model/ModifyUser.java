package com.example.springredisopenapi.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Modify user model.
 */

@Schema(name = "ModifyUser", description = "Modify user model.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class ModifyUser {

  private String name;

  private String email;

  private String gender;

  public ModifyUser name(String name) {
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

  public ModifyUser email(String email) {
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

  public ModifyUser gender(String gender) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyUser modifyUser = (ModifyUser) o;
    return Objects.equals(this.name, modifyUser.name) &&
        Objects.equals(this.email, modifyUser.email) &&
        Objects.equals(this.gender, modifyUser.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, gender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyUser {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
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

