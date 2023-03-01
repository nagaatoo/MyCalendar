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
import org.openapitools.client.model.Error;
import org.openapitools.client.model.Organization;
import org.openapitools.client.model.OrganizationCreate;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for OrganizationApi
 */
@Ignore
public class OrganizationApiTest {

    private final OrganizationApi api = new OrganizationApi();

    
    /**
     * 
     *
     * Обновить организацию
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdPutTest() throws ApiException {
        Long id = null;
        OrganizationCreate organizationCreate = null;
        Organization response = api.organizationIdPut(id, organizationCreate);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Создать организацию
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationPostTest() throws ApiException {
        OrganizationCreate organizationCreate = null;
        Organization response = api.organizationPost(organizationCreate);

        // TODO: test validations
    }
    
}
