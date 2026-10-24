REST Assured API Automation Framework
A Java and Maven project for exercising user-related REST APIs with REST Assured and TestNG. The current examples target the public Swagger Petstore service at https://petstore.swagger.io.

Features
Sends HTTP requests using REST Assured.
Uses a shared base service for the Petstore URL and common JSON POST, GET, and PUT requests.
Uses Java request/response models to represent user data and API responses.
Includes tests for creating users, creating users with array/list endpoints, login, retrieving a user, logout, and updating a user.
Requirements
JDK 17 or newer.
Apache Maven 3.6 or newer.
Network access to https://petstore.swagger.io to run the integration tests.
Run the tests
From the project root:

mvn test

To run one test class:

mvn -Dtest=LoginAPITest2 test

These are integration tests against a public service, not isolated unit tests. They send real HTTP requests and may depend on service availability, test data, and the remote API's current behavior. Avoid using sensitive or personal information in test payloads.

Project structure
.
+-- pom.xml
+-- src
|   +-- main
|   |   +-- java/com/api/App.java
|   +-- test
|       +-- java/com/api
|           +-- LoginAPITest.java
|           +-- LoginAPITest1.java
|           +-- LoginAPITest2.java
|           +-- base
|           |   +-- AuthService.java
|           |   +-- BaseService.java
|           +-- models
|               +-- reponse/LoginResponse.java
|               +-- request/LoginRequest.java
+-- .gitignore
The reponse package name is spelled that way in the current source tree.

Main components
BaseService configures the shared Petstore base URL and provides helpers for JSON POST, GET, and PUT requests.
AuthService wraps user-related Petstore operations and returns REST Assured Response objects.
LoginRequest models user ID, username, name, email, password, phone, and user status.
LoginResponse models the API's code, type, and message fields.
LoginAPITest, LoginAPITest1, and LoginAPITest2 are TestNG test classes demonstrating direct REST Assured requests and the service/model layers.
App is a basic application entry point; the API examples are under test sources.
Dependencies
The Maven project is configured for Java 17 and includes REST Assured, TestNG, JUnit Jupiter API/params, and Jackson dependencies. Dependency versions are declared in pom.xml.

Extending the framework
Add new request and response models under src/test/java/com/api/models, add endpoint methods to the appropriate service class, and write TestNG tests under src/test/java. Keep assertions tied to the actual HTTP status and parsed response fields, and avoid relying on Response.toString() to inspect a response body.
