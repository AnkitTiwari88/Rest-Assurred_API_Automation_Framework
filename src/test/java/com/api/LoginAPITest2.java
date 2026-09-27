package com.api;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class LoginAPITest2 {

    @Test( description = "Verify if login API working...")
    public void loginTest() {
        AuthService authService = new AuthService();
        Response response = authService.createUser("{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"ankit\",\n" +
                "  \"firstName\": \"Ankit\",\n" +
                "  \"lastName\": \"Tiwari\",\n" +
                "  \"email\": \"abc@gmail.com\",\n" +
                "  \"password\": \"ankit\",\n" +
                "  \"phone\": \"9823984586\",\n" +
                "  \"userStatus\": 1\n" +
                "}");
        System.out.println(response.asPrettyString());




    }


}
