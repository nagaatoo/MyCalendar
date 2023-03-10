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


import org.openapitools.client.model.Error;
import org.openapitools.client.model.User;
import org.openapitools.client.model.UserAuth;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient localVarApiClient;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for userAuthPost
     * @param userAuth  (optional)
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
    public okhttp3.Call userAuthPostCall(UserAuth userAuth, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = userAuth;

        // create path and map variables
        String localVarPath = "/user/auth";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json"
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
    private okhttp3.Call userAuthPostValidateBeforeCall(UserAuth userAuth, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = userAuthPostCall(userAuth, _callback);
        return localVarCall;

    }

    /**
     * 
     * 
     * @param userAuth  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public String userAuthPost(UserAuth userAuth) throws ApiException {
        ApiResponse<String> localVarResp = userAuthPostWithHttpInfo(userAuth);
        return localVarResp.getData();
    }

    /**
     * 
     * 
     * @param userAuth  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> userAuthPostWithHttpInfo(UserAuth userAuth) throws ApiException {
        okhttp3.Call localVarCall = userAuthPostValidateBeforeCall(userAuth, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param userAuth  (optional)
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
    public okhttp3.Call userAuthPostAsync(UserAuth userAuth, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = userAuthPostValidateBeforeCall(userAuth, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userPut
     * @param user  (optional)
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
    public okhttp3.Call userPutCall(User user, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = user;

        // create path and map variables
        String localVarPath = "/user";

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
    private okhttp3.Call userPutValidateBeforeCall(User user, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = userPutCall(user, _callback);
        return localVarCall;

    }

    /**
     * 
     * Обновить данные учетной записи
     * @param user  (optional)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public User userPut(User user) throws ApiException {
        ApiResponse<User> localVarResp = userPutWithHttpInfo(user);
        return localVarResp.getData();
    }

    /**
     * 
     * Обновить данные учетной записи
     * @param user  (optional)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Создано </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Ошибка запроса </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<User> userPutWithHttpInfo(User user) throws ApiException {
        okhttp3.Call localVarCall = userPutValidateBeforeCall(user, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Обновить данные учетной записи
     * @param user  (optional)
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
    public okhttp3.Call userPutAsync(User user, final ApiCallback<User> _callback) throws ApiException {

        okhttp3.Call localVarCall = userPutValidateBeforeCall(user, _callback);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
