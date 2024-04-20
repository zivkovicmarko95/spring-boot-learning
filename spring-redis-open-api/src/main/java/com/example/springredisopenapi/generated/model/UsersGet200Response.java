package com.example.springredisopenapi.generated.model;

import java.net.URI;
import java.util.Objects;
import com.example.springredisopenapi.generated.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
 * UsersGet200Response
 */

@JsonTypeName("usersGet_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class UsersGet200Response {

  private Integer total;

  @Valid
  private List<@Valid User> results;

  public UsersGet200Response total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  
  @Schema(name = "total", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public UsersGet200Response results(List<@Valid User> results) {
    this.results = results;
    return this;
  }

  public UsersGet200Response addResultsItem(User resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  */
  @Valid 
  @Schema(name = "results", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("results")
  public List<@Valid User> getResults() {
    return results;
  }

  public void setResults(List<@Valid User> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersGet200Response usersGet200Response = (UsersGet200Response) o;
    return Objects.equals(this.total, usersGet200Response.total) &&
        Objects.equals(this.results, usersGet200Response.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersGet200Response {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

