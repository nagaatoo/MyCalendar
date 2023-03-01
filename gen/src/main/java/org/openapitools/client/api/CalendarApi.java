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

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.Calendar;
import org.openapitools.client.model.CalendarCreate;
import org.openapitools.client.model.Error;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarApi {
    private ApiClient localVarApiClient;

    public CalendarApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CalendarApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for calendar
     * @param calendarCreate  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call calendarCall(CalendarCreate calendarCreate, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = calendarCreate;

        // create path and map variables
        String localVarPath = "/calendar";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call calendarValidateBeforeCall(CalendarCreate calendarCreate, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = calendarCall(calendarCreate, _callback);
        return localVarCall;

    }

    /**
     * 
     * Создать календарь
     * @param calendarCreate  (optional)
     * @return Calendar
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public Calendar calendar(CalendarCreate calendarCreate) throws ApiException {
        ApiResponse<Calendar> localVarResp = calendarWithHttpInfo(calendarCreate);
        return localVarResp.getData();
    }

    /**
     * 
     * Создать календарь
     * @param calendarCreate  (optional)
     * @return ApiResponse&lt;Calendar&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Calendar> calendarWithHttpInfo(CalendarCreate calendarCreate) throws ApiException {
        okhttp3.Call localVarCall = calendarValidateBeforeCall(calendarCreate, null);
        Type localVarReturnType = new TypeToken<Calendar>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Создать календарь
     * @param calendarCreate  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call calendarAsync(CalendarCreate calendarCreate, final ApiCallback<Calendar> _callback) throws ApiException {

        okhttp3.Call localVarCall = calendarValidateBeforeCall(calendarCreate, _callback);
        Type localVarReturnType = new TypeToken<Calendar>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for calendarHolidaysLoadPost
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Обновлено </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call calendarHolidaysLoadPostCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/calendar/holidays/load";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call calendarHolidaysLoadPostValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = calendarHolidaysLoadPostCall(_callback);
        return localVarCall;

    }

    /**
     * 
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Обновлено </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public void calendarHolidaysLoadPost() throws ApiException {
        calendarHolidaysLoadPostWithHttpInfo();
    }

    /**
     * 
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Обновлено </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> calendarHolidaysLoadPostWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = calendarHolidaysLoadPostValidateBeforeCall(null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     *  (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Обновлено </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call calendarHolidaysLoadPostAsync(final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = calendarHolidaysLoadPostValidateBeforeCall(_callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for calendarIdPut
     * @param id Идентификатор календаря (required)
     * @param calendarCreate  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call calendarIdPutCall(Long id, CalendarCreate calendarCreate, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = calendarCreate;

        // create path and map variables
        String localVarPath = "/calendar/{id}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call calendarIdPutValidateBeforeCall(Long id, CalendarCreate calendarCreate, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling calendarIdPut(Async)");
        }
        

        okhttp3.Call localVarCall = calendarIdPutCall(id, calendarCreate, _callback);
        return localVarCall;

    }

    /**
     * 
     * Обновить календарь
     * @param id Идентификатор календаря (required)
     * @param calendarCreate  (optional)
     * @return Calendar
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public Calendar calendarIdPut(Long id, CalendarCreate calendarCreate) throws ApiException {
        ApiResponse<Calendar> localVarResp = calendarIdPutWithHttpInfo(id, calendarCreate);
        return localVarResp.getData();
    }

    /**
     * 
     * Обновить календарь
     * @param id Идентификатор календаря (required)
     * @param calendarCreate  (optional)
     * @return ApiResponse&lt;Calendar&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Calendar> calendarIdPutWithHttpInfo(Long id, CalendarCreate calendarCreate) throws ApiException {
        okhttp3.Call localVarCall = calendarIdPutValidateBeforeCall(id, calendarCreate, null);
        Type localVarReturnType = new TypeToken<Calendar>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Обновить календарь
     * @param id Идентификатор календаря (required)
     * @param calendarCreate  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call calendarIdPutAsync(Long id, CalendarCreate calendarCreate, final ApiCallback<Calendar> _callback) throws ApiException {

        okhttp3.Call localVarCall = calendarIdPutValidateBeforeCall(id, calendarCreate, _callback);
        Type localVarReturnType = new TypeToken<Calendar>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
