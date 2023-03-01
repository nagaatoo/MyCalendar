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
import org.openapitools.client.model.Organization;
import org.openapitools.client.model.ScheduleShort;
import org.threeten.bp.LocalDate;

/**
 * Календарь
 */
@ApiModel(description = "Календарь")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-02T02:34:45.648669+06:00[Asia/Almaty]")
public class Calendar {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Long id;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private Object owner;

  public static final String SERIALIZED_NAME_ORGANIZATION = "organization";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION)
  private Organization organization;

  public static final String SERIALIZED_NAME_SCHEDULES = "schedules";
  @SerializedName(SERIALIZED_NAME_SCHEDULES)
  private ScheduleShort schedules;

  public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private LocalDate created;

  public static final String SERIALIZED_NAME_UPDATED_BY = "updatedBy";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY)
  private String updatedBy;

  public static final String SERIALIZED_NAME_UPDATE = "update";
  @SerializedName(SERIALIZED_NAME_UPDATE)
  private LocalDate update;


  public Calendar id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Calendar title(String title) {
    
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


  public Calendar owner(Object owner) {
    
    this.owner = owner;
    return this;
  }

   /**
   * Логин владельца
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Логин владельца")

  public Object getOwner() {
    return owner;
  }


  public void setOwner(Object owner) {
    this.owner = owner;
  }


  public Calendar organization(Organization organization) {
    
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Organization getOrganization() {
    return organization;
  }


  public void setOrganization(Organization organization) {
    this.organization = organization;
  }


  public Calendar schedules(ScheduleShort schedules) {
    
    this.schedules = schedules;
    return this;
  }

   /**
   * Get schedules
   * @return schedules
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ScheduleShort getSchedules() {
    return schedules;
  }


  public void setSchedules(ScheduleShort schedules) {
    this.schedules = schedules;
  }


  public Calendar createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Создатель
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Создатель")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public Calendar created(LocalDate created) {
    
    this.created = created;
    return this;
  }

   /**
   * Дата создания
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Дата создания")

  public LocalDate getCreated() {
    return created;
  }


  public void setCreated(LocalDate created) {
    this.created = created;
  }


  public Calendar updatedBy(String updatedBy) {
    
    this.updatedBy = updatedBy;
    return this;
  }

   /**
   * Обновлено
   * @return updatedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Обновлено")

  public String getUpdatedBy() {
    return updatedBy;
  }


  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }


  public Calendar update(LocalDate update) {
    
    this.update = update;
    return this;
  }

   /**
   * Дата обновления
   * @return update
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Дата обновления")

  public LocalDate getUpdate() {
    return update;
  }


  public void setUpdate(LocalDate update) {
    this.update = update;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Calendar calendar = (Calendar) o;
    return Objects.equals(this.id, calendar.id) &&
        Objects.equals(this.title, calendar.title) &&
        Objects.equals(this.owner, calendar.owner) &&
        Objects.equals(this.organization, calendar.organization) &&
        Objects.equals(this.schedules, calendar.schedules) &&
        Objects.equals(this.createdBy, calendar.createdBy) &&
        Objects.equals(this.created, calendar.created) &&
        Objects.equals(this.updatedBy, calendar.updatedBy) &&
        Objects.equals(this.update, calendar.update);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, owner, organization, schedules, createdBy, created, updatedBy, update);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Calendar {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    update: ").append(toIndentedString(update)).append("\n");
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
