# OrganizationApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**organizationIdPut**](OrganizationApi.md#organizationIdPut) | **PUT** /organization/{id} | 
[**organizationPost**](OrganizationApi.md#organizationPost) | **POST** /organization | 


<a name="organizationIdPut"></a>
# **organizationIdPut**
> Organization organizationIdPut(id, organizationCreate)



Обновить организацию

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrganizationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    OrganizationApi apiInstance = new OrganizationApi(defaultClient);
    Long id = 56L; // Long | Идентификатор организции
    OrganizationCreate organizationCreate = new OrganizationCreate(); // OrganizationCreate | 
    try {
      Organization result = apiInstance.organizationIdPut(id, organizationCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrganizationApi#organizationIdPut");
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
 **id** | **Long**| Идентификатор организции |
 **organizationCreate** | [**OrganizationCreate**](OrganizationCreate.md)|  | [optional]

### Return type

[**Organization**](Organization.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | ОБновлено |  -  |
**400** | Ошибка запроса |  -  |

<a name="organizationPost"></a>
# **organizationPost**
> Organization organizationPost(organizationCreate)



Создать организацию

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrganizationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    OrganizationApi apiInstance = new OrganizationApi(defaultClient);
    OrganizationCreate organizationCreate = new OrganizationCreate(); // OrganizationCreate | 
    try {
      Organization result = apiInstance.organizationPost(organizationCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrganizationApi#organizationPost");
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
 **organizationCreate** | [**OrganizationCreate**](OrganizationCreate.md)|  | [optional]

### Return type

[**Organization**](Organization.md)

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

