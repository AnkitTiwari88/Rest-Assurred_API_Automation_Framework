package com.api;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginAPITest1 {

    @Test( description = "Verify if login API working...")
    public void loginTest() {
        Response response =  given().baseUri("https://petstore.swagger.io").header("Content-Type", "application/json").body("{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"ankit\",\n" +
                "  \"firstName\": \"Ankit\",\n" +
                "  \"lastName\": \"Tiwari\",\n" +
                "  \"email\": \"abc@gmail.com\",\n" +
                "  \"password\": \"ankit\",\n" +
                "  \"phone\": \"9823984586\",\n" +
                "  \"userStatus\": 1\n" +
                "}").post("/v2/user");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);


    }


}
