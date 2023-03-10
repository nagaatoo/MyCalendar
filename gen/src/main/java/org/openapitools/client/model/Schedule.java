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
import org.threeten.bp.LocalDate;

/**
 * Расписание
 */
@ApiModel(description = "Расписание")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-02T02:34:45.648669+06:00[Asia/Almaty]")
public class Schedule {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Long id;

  public static final String SERIALIZED_NAME_WORK_DAYS = "workDays";
  @SerializedName(SERIALIZED_NAME_WORK_DAYS)
  private Integer workDays;

  public static final String SERIALIZED_NAME_WEEKEND_DAYS = "weekendDays";
  @SerializedName(SERIALIZED_NAME_WEEKEND_DAYS)
  private Integer weekendDays;

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

  public static final String SERIALIZED_NAME_DAYS = "days";
  @SerializedName(SERIALIZED_NAME_DAYS)
  private String days;


  public Schedule id(Long id) {
    
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


  public Schedule workDays(Integer workDays) {
    
    this.workDays = workDays;
    return this;
  }

   /**
   * Диапазон рабочих дней
   * @return workDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Диапазон рабочих дней")

  public Integer getWorkDays() {
    return workDays;
  }


  public void setWorkDays(Integer workDays) {
    this.workDays = workDays;
  }


  public Schedule weekendDays(Integer weekendDays) {
    
    this.weekendDays = weekendDays;
    return this;
  }

   /**
   * Диапазон не рабочих дней
   * @return weekendDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Диапазон не рабочих дней")

  public Integer getWeekendDays() {
    return weekendDays;
  }


  public void setWeekendDays(Integer weekendDays) {
    this.weekendDays = weekendDays;
  }


  public Schedule createdBy(String createdBy) {
    
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


  public Schedule created(LocalDate created) {
    
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


  public Schedule updatedBy(String updatedBy) {
    
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


  public Schedule update(LocalDate update) {
    
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


  public Schedule days(String days) {
    
    this.days = days;
    return this;
  }

   /**
   * Сетка расписания
   * @return days
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Сетка расписания")

  public String getDays() {
    return days;
  }


  public void setDays(String days) {
    this.days = days;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Schedule schedule = (Schedule) o;
    return Objects.equals(this.id, schedule.id) &&
        Objects.equals(this.workDays, schedule.workDays) &&
        Objects.equals(this.weekendDays, schedule.weekendDays) &&
        Objects.equals(this.createdBy, schedule.createdBy) &&
        Objects.equals(this.created, schedule.created) &&
        Objects.equals(this.updatedBy, schedule.updatedBy) &&
        Objects.equals(this.update, schedule.update) &&
        Objects.equals(this.days, schedule.days);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, workDays, weekendDays, createdBy, created, updatedBy, update, days);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Schedule {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    workDays: ").append(toIndentedString(workDays)).append("\n");
    sb.append("    weekendDays: ").append(toIndentedString(weekendDays)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    update: ").append(toIndentedString(update)).append("\n");
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
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

