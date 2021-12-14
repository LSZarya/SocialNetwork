package TestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegistrationApiBE {

    String api = "http://45.134.255.54:8086/";

    @Test (enabled = false)
    public void test_registration_Lev() {

        RestAssured.baseURI = api;
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "levagoli@mail.ru");
        requestParams.put("firstName", "lev");
        requestParams.put("lastName", "lev");
        requestParams.put("passwd1", "1234567a");
        requestParams.put("passwd2", "1234567a");

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/account/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Test
    public void test_registration_ok() {

        RestAssured.baseURI = api;
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "lev" + (int) (Math.random() * 10000) + "@mail.ru");
        requestParams.put("firstName", "lev");
        requestParams.put("lastName", "lev");
        requestParams.put("passwd1", "1234567a");
        requestParams.put("passwd2", "1234567a");

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/account/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Test
    public void test_registration_zero() {

        RestAssured.baseURI = api;
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

//        requestParams.put("email", "levagoli@mail.ru");
//        requestParams.put("firstName", "lev");
//        requestParams.put("lastName", "lev");
//        requestParams.put("passwd1", "1234567a");
//        requestParams.put("passwd2", "1234567a");

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/account/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(500, statusCode);
    }

    @Test
    public void test_registration_OneEmail() {

        RestAssured.baseURI = api;
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "lev" + (int) (Math.random() * 1000) + "@mail.ru");
//        requestParams.put("firstName", "lev");
//        requestParams.put("lastName", "lev");
//        requestParams.put("passwd1", "1234567a");
//        requestParams.put("passwd2", "1234567a");

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/account/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(500, statusCode);
    }

    @Test
    public void test_registration_NoOdinacoviePassword() {

        RestAssured.baseURI = api;
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "lev" + (int) (Math.random() * 1000) + "@mail.ru");
        requestParams.put("firstName", "lev");
        requestParams.put("lastName", "lev");
        requestParams.put("passwd1", "1234567");
        requestParams.put("passwd2", "1234567a");

        System.out.println(JSONObject.toJSONString(requestParams));//Метод просмотра json

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.post("/api/v1/account/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(400, statusCode);
    }

}
