package com.api;

import com.api.base.AuthService;
import com.api.models.reponse.LoginResponse;
import com.api.models.request.LoginRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Integration tests for the user-related operations exposed by {@link AuthService}.
 */
public class LoginAPITest2 {

    @Test(description = "Verify user creation, login, retrieval, logout, and update operations")
    public void loginTest() {
        // Create a user and verify the service accepts the request.
        LoginRequest loginRequest = new LoginRequest(
                "1", "ankit", "Ankit", "Tiwari", "abc@gmail.com", "ankit", "9823984586", "1");
        AuthService authService = new AuthService();
        Response response = authService.createUser(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println("Create User Response:");
        System.out.println(response.asPrettyString());
        System.out.println("code: " + loginResponse.getCode());
        System.out.println("type: " + loginResponse.getType());
        System.out.println("message: " + loginResponse.getMessage());
        Assert.assertTrue(
                response.getStatusCode() == 200,
                "Expected status code 200 but got " + response.getStatusCode());

        // Create a user using the array-based endpoint and validate its response.
        LoginRequest[] loginRequests = new LoginRequest[1];
        loginRequests[0] = new LoginRequest(
                "2", "ankit1", "Ankit1", "Tiwari1", "abc1@gmail.com", "ankit1", "9823984587", "2");
        Response response1 = authService.createWithArray(loginRequests);

        System.out.println("Create With Array Response:");
        System.out.println(response1.asPrettyString());
        Assert.assertEquals(
                response1.getStatusCode(), 200,
                "Expected status code 200 but got " + response1.getStatusCode());
        Assert.assertEquals(
                response1.jsonPath().getInt("code"), 200,
                "Expected response code 200 but got " + response1.jsonPath().getInt("code"));
        Assert.assertEquals(
                response1.jsonPath().getString("type"), "unknown",
                "Expected type unknown but got " + response1.jsonPath().getString("type"));
        Assert.assertEquals(
                response1.jsonPath().getString("message"), "ok",
                "Expected message ok but got " + response1.jsonPath().getString("message"));

        // Create a user using the list-based endpoint.
        LoginRequest[] loginRequests2 = new LoginRequest[1];
        loginRequests2[0] = new LoginRequest(
                "3", "ankit2", "Ankit2", "Tiwari2", "abc2@gmail.com", "ankit2", "9823984588", "3");
        Response response2 = authService.createWithList(loginRequests2);

        System.out.println("Create With List Response:");
        System.out.println(response2.asPrettyString());

        // Authenticate the user.
        Response response3 = authService.loginUser("ankit", "ankit");
        System.out.println("Login User Response:");
        System.out.println(response3.asPrettyString());

        // Retrieve a user by username and verify the returned profile.
        Response response4 = authService.getUserByUsername("juli");
        System.out.println("Get User By Username Response:");
        System.out.println(response4.asPrettyString());
        Assert.assertEquals(
                response4.jsonPath().getString("username"), "juli",
                "Expected username juli but got " + response4.jsonPath().getString("username"));
        Assert.assertEquals(
                response4.jsonPath().getString("firstName"), "Ankit",
                "Expected firstName Ankit but got " + response4.jsonPath().getString("firstName"));
        Assert.assertEquals(
                response4.jsonPath().getString("lastName"), "singh",
                "Expected lastName singh but got " + response4.jsonPath().getString("lastName"));

        // Log out and verify the service response.
        Response response5 = authService.logoutUser();
        System.out.println("Logout User Response:");
        System.out.println(response5.asPrettyString());
        Assert.assertEquals(
                response5.jsonPath().getString("code"), "200",
                "Expected code 200 but got " + response5.jsonPath().getString("code"));
        Assert.assertEquals(
                response5.jsonPath().getString("message"), "ok",
                "Expected message ok but got " + response5.jsonPath().getString("message"));

        // Update the user profile.
        LoginRequest loginRequest2 = new LoginRequest(
                "1", "juli", "Ankit", "singh", "abc@gmail.com", "ankit", "9823984587", "1");
        Response response6 = authService.updateUser("Ankit", loginRequest2);
        System.out.println("Update User Response:");
        System.out.println(response6.asPrettyString());

    }
}
