/*
 * MyCalendar API
 * API для календаря
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CalendarCreate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-02T02:34:45.648669+06:00[Asia/Almaty]")
public class CalendarCreate {
  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_OWNER_LOGIN = "ownerLogin";
  @SerializedName(SERIALIZED_NAME_OWNER_LOGIN)
  private String ownerLogin;

  public static final String SERIALIZED_NAME_ORGANIZATION_ID = "organizationId";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_ID)
  private Long organizationId;


  public CalendarCreate title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Наименование
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Наименование")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public CalendarCreate ownerLogin(String ownerLogin) {
    
    this.ownerLogin = ownerLogin;
    return this;
  }

   /**
   * Get ownerLogin
   * @return ownerLogin
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOwnerLogin() {
    return ownerLogin;
  }


  public void setOwnerLogin(String ownerLogin) {
    this.ownerLogin = ownerLogin;
  }


  public CalendarCreate organizationId(Long organizationId) {
    
    this.organizationId = organizationId;
    return this;
  }

   /**
   * Организация
   * @return organizationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Организация")

  public Long getOrganizationId() {
    return organizationId;
  }


  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalendarCreate calendarCreate = (CalendarCreate) o;
    return Objects.equals(this.title, calendarCreate.title) &&
        Objects.equals(this.ownerLogin, calendarCreate.ownerLogin) &&
        Objects.equals(this.organizationId, calendarCreate.organizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, ownerLogin, organizationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalendarCreate {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    ownerLogin: ").append(toIndentedString(ownerLogin)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
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

