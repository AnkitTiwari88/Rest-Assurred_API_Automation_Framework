package com.api;

import com.api.base.AuthService;
import com.api.models.reponse.LoginResponse;
import com.api.models.request.LoginRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class LoginAPITest2 {

    @Test( description = "Verify if login API working...")
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest("1", "ankit", "Ankit", "Tiwari", "abc@gmail.com", "ankit", "9823984586","1");
        AuthService authService = new AuthService();
        Response response = authService.createUser(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println("code: " + loginResponse.getCode());
        System.out.println("type: " + loginResponse.getType());
        System.out.println("message: " + loginResponse.getMessage());

        Assert.assertTrue(response.getStatusCode() == 200, "Expected status code 200 but got " + response.getStatusCode());



    }


}
