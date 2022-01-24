package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

public class apiTest2 {

    @Test
    public void getAllUsers() {
        // Setup RestAssured
        RestAssured.baseURI = "https://aqa5master.testrail.io";
        String endpoint = "/index.php?/api/v2/get_users";


        // Setup Request Object
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);

        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
