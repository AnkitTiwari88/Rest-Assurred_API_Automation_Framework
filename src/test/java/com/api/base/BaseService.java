package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
//base URI
//    Creating request
//    Handling response

    private static final String BASE_URL = "https://petstore.swagger.io";
    private RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }



}
