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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Calendar;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.Schedule;
import org.openapitools.client.model.ScheduleCreate;
import org.openapitools.client.model.ScheduleGenerate;
import org.openapitools.client.model.ScheduleList;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ScheduleApi
 */
@Ignore
public class ScheduleApiTest {

    private final ScheduleApi api = new ScheduleApi();

    
    /**
     * 
     *
     * Получить все расписания календаря пользователя
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void v1ScheduleCalendarIdGetTest() throws ApiException {
        Long calendarId = null;
        Integer pageNo = null;
        Integer pageSize = null;
        String filter = null;
        ScheduleList response = api.v1ScheduleCalendarIdGet(calendarId, pageNo, pageSize, filter);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Обновить календарь
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void v1SchedulePutTest() throws ApiException {
        ScheduleCreate scheduleCreate = null;
        Calendar response = api.v1SchedulePut(scheduleCreate);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Создать календарь
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void v1ScheduleScheduleIdGeneratePostTest() throws ApiException {
        Long scheduleId = null;
        ScheduleGenerate scheduleGenerate = null;
        Schedule response = api.v1ScheduleScheduleIdGeneratePost(scheduleId, scheduleGenerate);

        // TODO: test validations
    }
    
}
