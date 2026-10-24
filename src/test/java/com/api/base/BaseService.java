package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    // Base URL shared by all API calls in the project.
    private static final String BASE_URL = "https://petstore.swagger.io";

    // Common RestAssured request specification used for creating API requests.
    private RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    // Sends a POST request with JSON payload and returns the HTTP response.
    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    // Sends a GET request and returns the HTTP response.
    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }

    // Sends a PUT request with JSON payload and returns the HTTP response.
    protected Response putRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

}
