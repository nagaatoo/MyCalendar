# ScheduleApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**scheduleCalendarIdGet**](ScheduleApi.md#scheduleCalendarIdGet) | **GET** /schedule/{calendarId} | 
[**schedulePut**](ScheduleApi.md#schedulePut) | **PUT** /schedule | 
[**scheduleScheduleIdGeneratePost**](ScheduleApi.md#scheduleScheduleIdGeneratePost) | **POST** /schedule/{scheduleId}/generate | 


<a name="scheduleCalendarIdGet"></a>
# **scheduleCalendarIdGet**
> ScheduleList scheduleCalendarIdGet(calendarId, pageNo, pageSize, filter)



Получить все расписания календаря пользователя

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ScheduleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ScheduleApi apiInstance = new ScheduleApi(defaultClient);
    Long calendarId = 56L; // Long | Идентификатор календаря
    Integer pageNo = 56; // Integer | Страница
    Integer pageSize = 56; // Integer | Размер страницы
    String filter = "filter_example"; // String | Быстрый фильтр
    try {
      ScheduleList result = apiInstance.scheduleCalendarIdGet(calendarId, pageNo, pageSize, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ScheduleApi#scheduleCalendarIdGet");
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
 **calendarId** | **Long**| Идентификатор календаря |
 **pageNo** | **Integer**| Страница | [optional]
 **pageSize** | **Integer**| Размер страницы | [optional]
 **filter** | **String**| Быстрый фильтр | [optional]

### Return type

[**ScheduleList**](ScheduleList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Список календарей |  -  |
**400** | Ошибка запроса |  -  |

<a name="schedulePut"></a>
# **schedulePut**
> Calendar schedulePut(scheduleCreate)



Обновить календарь

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ScheduleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ScheduleApi apiInstance = new ScheduleApi(defaultClient);
    ScheduleCreate scheduleCreate = new ScheduleCreate(); // ScheduleCreate | 
    try {
      Calendar result = apiInstance.schedulePut(scheduleCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ScheduleApi#schedulePut");
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
 **scheduleCreate** | [**ScheduleCreate**](ScheduleCreate.md)|  | [optional]

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

<a name="scheduleScheduleIdGeneratePost"></a>
# **scheduleScheduleIdGeneratePost**
> Schedule scheduleScheduleIdGeneratePost(scheduleId, scheduleGenerate)



Создать календарь

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ScheduleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ScheduleApi apiInstance = new ScheduleApi(defaultClient);
    Long scheduleId = 56L; // Long | Идетификатор расписания
    ScheduleGenerate scheduleGenerate = new ScheduleGenerate(); // ScheduleGenerate | 
    try {
      Schedule result = apiInstance.scheduleScheduleIdGeneratePost(scheduleId, scheduleGenerate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ScheduleApi#scheduleScheduleIdGeneratePost");
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
 **scheduleId** | **Long**| Идетификатор расписания |
 **scheduleGenerate** | [**ScheduleGenerate**](ScheduleGenerate.md)|  | [optional]

### Return type

[**Schedule**](Schedule.md)

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

