package core.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.UserType;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
public class RestManager {
    protected Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public RestManager() {
        RestAssured.baseURI = ReadProperties.getUrl();
    }

    /**
     * Sends POST request to URL.
     *
     * @param requestURL URL.
     * @param params     path parameters.
     * @return response.
     */
    public Response post(String requestURL, Map<String, String> params, UserType userType, Object body) {
        log.info("Sending POST request to {} with parameters {}", requestURL, params);
        RequestSpecification requestSpecification = this.getBasicRequestSpecifications(params, userType, body);

        return given(requestSpecification)
                .log().all()
                .post(requestURL)
                .then()
                .log().all()
                .extract().response();
    }

    public <T> T get(String requestURL, Map<String, String> params, UserType userType, Object body, Class<T> classOfT) {
        return gson.fromJson(get(requestURL, params, userType, body)
                .asString().trim(), classOfT);
    }

    /**
     * Sends GET request to URL.
     *
     * @param requestURL URL.
     * @param params     path parameters.
     * @return response.
     */
    public Response get(String requestURL, Map<String, String> params, UserType userType, Object body) {
        log.info("Sending POST request to {} with parameters {}", requestURL, params);
        RequestSpecification requestSpecification = this.getBasicRequestSpecifications(params, userType, body);

        return given(requestSpecification)
                .log().all()
                .get(requestURL)
                .then()
                .log().all()
                .extract().response();
    }

    private RequestSpecification getBasicRequestSpecifications(Map<String, String> params, UserType userType, Object body) {
        String username = "";
        String password = "";

        switch (userType) {
            case ADMIN:
                username = ReadProperties.getUsername();
                password = ReadProperties.getPassword();
                break;
            default:
                log.error("User credentials are incorrect.");
                break;
        }

        RequestSpecification requestSpecification = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(username, password);

        if (params != null) {
            requestSpecification.pathParams(params);
        }

        if (body != null) {
            requestSpecification.body(body);
        }
        return requestSpecification;
    }
}
