package com.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginAPITest {

    @Test( description = "Verify if login API working...")
    public void loginTest() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification rs = RestAssured.given();
        RequestSpecification y =  rs.header("Content-Type", "application/json");
        RequestSpecification z = y.body("{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"ankit\",\n" +
                "  \"firstName\": \"Ankit\",\n" +
                "  \"lastName\": \"Tiwari\",\n" +
                "  \"email\": \"abc@gmail.com\",\n" +
                "  \"password\": \"ankit\",\n" +
                "  \"phone\": \"9823984586\",\n" +
                "  \"userStatus\": 1\n" +
                "}");
        Response response =  z.post("/v2/user");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);


    }


}
