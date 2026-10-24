package com.api.base;

import com.api.models.request.LoginRequest;
import io.restassured.response.Response;

public class AuthService extends BaseService {
   // Base path for Petstore user-related endpoints.
   private static final String BASE_PATH = "/v2/";

   // Creates a new user in the system.
   public Response createUser(LoginRequest payload) {
      return postRequest(payload, BASE_PATH + "user");
   }

   // Creates multiple users from an array payload.
   public Response createWithArray(LoginRequest[] payload) {
        return postRequest(payload, BASE_PATH + "user/createWithArray");
   }

   // Creates multiple users from a list payload.
   public Response createWithList(LoginRequest[] payload) {
        return postRequest(payload, BASE_PATH + "user/createWithList");
   }

   // Authenticates a user with the provided username and password.
   public Response loginUser(String username, String password) {
        return getRequest(BASE_PATH + "user/login?username=" + username + "&password=" + password);
   }

   // Fetches user details for the given username.
   public Response getUserByUsername(String username) {
        return getRequest(BASE_PATH + "user/" + username);
   }

   // Logs out the currently authenticated user.
   public Response logoutUser() {
        return getRequest(BASE_PATH + "user/logout");
   }

   // Updates an existing user record for the specified username.
   public Response updateUser(String username, LoginRequest payload) {
        return putRequest(payload, BASE_PATH + "user/" + username);
   }

}
