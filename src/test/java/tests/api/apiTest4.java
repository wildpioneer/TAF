package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User1;
import models.UserSimple;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class apiTest4 extends BaseApiTest {
    int projectID;

    @Test
    public void getAllUsers2() {
        String endpoint = "/index.php?/api/v2/get_users";

        UserSimple userSimple = new UserSimple.Builder()
                .withName("Alex Tros")
                .withEmail("atrostyanko+0401@gmail.com")
                .withIsActive(true)
                .build();

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .body("get(0).name", is(userSimple.getName()))
                .body("get(0).email", equalTo(userSimple.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllUsers2_1() {
        String endpoint = "/index.php?/api/v2/get_users";
        Gson gson = new Gson();

        User1 user = User1.builder()
                .name("Alex Tros")
                .email("atrostyanko+0401@gmail.com")
                .isActive(true)
                .role_id(1)
                .role("Lead")
                .build();

        Response response = given()
                .when()
                .get(endpoint);

/*
        // Complex Type
        Type listType = new TypeToken<ArrayList<User1>>() {}.getType();
        List<User1> actualUserList = gson.fromJson(response.getBody().asString(), listType);
*/

        User1[] actualUserList = gson.fromJson(response.getBody().asString(), User1[].class);

        System.out.println(actualUserList[0].toString());
        Assert.assertEquals(user, actualUserList[0]);
    }
}
