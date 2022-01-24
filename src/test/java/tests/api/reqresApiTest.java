package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class reqresApiTest {

    @Test
    public void simpleStepByStepTest() {
        // Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        // Setup Request Object
        RequestSpecification httpRequest = RestAssured.given();

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

    @Test
    public void simpleShortTest() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
