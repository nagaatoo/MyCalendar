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
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for HealthApi
 */
@Ignore
public class HealthApiTest {

    private final HealthApi api = new HealthApi();

    
    /**
     * Проверка доступности сервиса
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pingTest() throws ApiException {
        String response = api.ping();

        // TODO: test validations
    }
    
}
