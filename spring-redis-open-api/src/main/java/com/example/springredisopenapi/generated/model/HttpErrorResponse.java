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
 * HttpErrorResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class HttpErrorResponse {

  private String timeStamp;

  private Integer httpStatusCode;

  private String httpStatus;

  private String reason;

  private String message;

  public HttpErrorResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public HttpErrorResponse(String message) {
    this.message = message;
  }

  public HttpErrorResponse timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

  /**
   * Time when the response was sent.
   * @return timeStamp
  */
  
  @Schema(name = "timeStamp", accessMode = Schema.AccessMode.READ_ONLY, description = "Time when the response was sent.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timeStamp")
  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public HttpErrorResponse httpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

  /**
   * Status code of the response.
   * @return httpStatusCode
  */
  
  @Schema(name = "httpStatusCode", accessMode = Schema.AccessMode.READ_ONLY, description = "Status code of the response.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("httpStatusCode")
  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public HttpErrorResponse httpStatus(String httpStatus) {
    this.httpStatus = httpStatus;
    return this;
  }

  /**
   * Meaning of the HTTP status code.
   * @return httpStatus
  */
  
  @Schema(name = "httpStatus", accessMode = Schema.AccessMode.READ_ONLY, description = "Meaning of the HTTP status code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("httpStatus")
  public String getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(String httpStatus) {
    this.httpStatus = httpStatus;
  }

  public HttpErrorResponse reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * The description detailing the reason of the error code.
   * @return reason
  */
  
  @Schema(name = "reason", accessMode = Schema.AccessMode.READ_ONLY, description = "The description detailing the reason of the error code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reason")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public HttpErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The description detailing the cause of the error code.
   * @return message
  */
  
  @Schema(name = "message", accessMode = Schema.AccessMode.READ_ONLY, description = "The description detailing the cause of the error code.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HttpErrorResponse httpErrorResponse = (HttpErrorResponse) o;
    return Objects.equals(this.timeStamp, httpErrorResponse.timeStamp) &&
        Objects.equals(this.httpStatusCode, httpErrorResponse.httpStatusCode) &&
        Objects.equals(this.httpStatus, httpErrorResponse.httpStatus) &&
        Objects.equals(this.reason, httpErrorResponse.reason) &&
        Objects.equals(this.message, httpErrorResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeStamp, httpStatusCode, httpStatus, reason, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HttpErrorResponse {\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    httpStatus: ").append(toIndentedString(httpStatus)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

