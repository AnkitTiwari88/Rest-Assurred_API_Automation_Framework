package com.api.base;

import io.restassured.response.Response;

public class AuthService extends BaseService {
   private static final String BASE_PATH = "/v2/";

   public Response createUser(String payload) {
      return postRequest(payload, BASE_PATH+"user");
   }




}
