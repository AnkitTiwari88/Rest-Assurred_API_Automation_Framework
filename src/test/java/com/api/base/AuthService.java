package com.api.base;

import com.api.models.request.LoginRequest;
import io.restassured.response.Response;

public class AuthService extends BaseService {
   private static final String BASE_PATH = "/v2/";

   public Response createUser(LoginRequest payload) {
      return postRequest(payload, BASE_PATH+"user");
   }

   public Response createWithArray(LoginRequest[] payload) {
        return postRequest(payload, BASE_PATH+"user/createWithArray");
   }

   public Response createWithList(LoginRequest[] payload) {
        return postRequest(payload, BASE_PATH+"user/createWithList");
   }

   public Response loginUser(String username, String password) {
        return getRequest(BASE_PATH+"user/login?username=" + username + "&password=" + password);
   }

   public Response getUserByUsername(String username) {
        return getRequest(BASE_PATH+"user/" + username);
   }

   public Response logoutUser() {
        return getRequest(BASE_PATH+"user/logout");
   }



}
