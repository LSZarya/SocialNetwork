package TestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAuthorizationApiBE {
    String api = "http://45.134.255.54:8086/";

    @Test
    public void test_authorization_ok() {

        RestAssured.baseURI = api;
        RequestSpecification request = given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "levagoli@mail.ru");
        requestParams.put("password", "1234567a");

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/auth/login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Test
    public void test_authorization_zero() {

        RestAssured.baseURI = api;
        RequestSpecification request = given();

        JSONObject requestParams = new JSONObject();

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        Response response = request.post("/api/v1/auth/login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(403, statusCode);
    }

    @Test
    public void test_authorization_noPassword() {

        RestAssured.baseURI = api;
        RequestSpecification request = given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "levagoli@mail.ru");
        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        Response response = request.post("/api/v1/auth/login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(403, statusCode);
    }

    @Test
    public void test_authorization_noMail() {

        RestAssured.baseURI = api;
        RequestSpecification request = given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

//        requestParams.put("email", "");
        requestParams.put("password", "1234567a");

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/auth/login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(403, statusCode);
    }

}
