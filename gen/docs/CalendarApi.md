# CalendarApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**calendar**](CalendarApi.md#calendar) | **POST** /calendar | 
[**calendarHolidaysLoadPost**](CalendarApi.md#calendarHolidaysLoadPost) | **POST** /calendar/holidays/load | 
[**calendarIdPut**](CalendarApi.md#calendarIdPut) | **PUT** /calendar/{id} | 


<a name="calendar"></a>
# **calendar**
> Calendar calendar(calendarCreate)



Создать календарь

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    CalendarCreate calendarCreate = new CalendarCreate(); // CalendarCreate | 
    try {
      Calendar result = apiInstance.calendar(calendarCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#calendar");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **calendarCreate** | [**CalendarCreate**](CalendarCreate.md)|  | [optional]

### Return type

[**Calendar**](Calendar.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Создано |  -  |
**400** | Ошибка запроса |  -  |

<a name="calendarHolidaysLoadPost"></a>
# **calendarHolidaysLoadPost**
> calendarHolidaysLoadPost()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    try {
      apiInstance.calendarHolidaysLoadPost();
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#calendarHolidaysLoadPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Обновлено |  -  |
**400** | Ошибка запроса |  -  |

<a name="calendarIdPut"></a>
# **calendarIdPut**
> Calendar calendarIdPut(id, calendarCreate)



Обновить календарь

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    Long id = 56L; // Long | Идентификатор календаря
    CalendarCreate calendarCreate = new CalendarCreate(); // CalendarCreate | 
    try {
      Calendar result = apiInstance.calendarIdPut(id, calendarCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#calendarIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| Идентификатор календаря |
 **calendarCreate** | [**CalendarCreate**](CalendarCreate.md)|  | [optional]

### Return type

[**Calendar**](Calendar.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Создано |  -  |
**400** | Ошибка запроса |  -  |

