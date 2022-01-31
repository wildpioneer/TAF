package tests.api;

import baseEntity.BaseApiTest;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest2 extends BaseApiTest {

    @Test
    public void getAllUsers() {
        User user = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0401@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .body("get(0).name", is(user.getName()))
                .body("get(0).email", equalTo(user.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUser() {
        int userID = 1;

        User expectedUser = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0401@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParam("id", userID)
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUser1() {
        int userID = 1;
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0401@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .pathParam("id", userID)
                .get(Endpoints.GET_USER);

        User actualUser = gson.fromJson(response.getBody().asString(), User.class);

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUsers() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0401@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .get(Endpoints.GET_ALL_USERS);

        User[] actualUser = gson.fromJson(response.getBody().asString(), User[].class);

        Assert.assertEquals(actualUser[0], expectedUser);
    }

    @Test
    public void getUsers1() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0401@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .get(Endpoints.GET_ALL_USERS);

        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        List<User> actualUsersList = gson.fromJson(response.getBody().asString(), listType);

/*
        User[] actualUser = gson.fromJson(response.getBody().asString(), User[].class);
        Assert.assertEquals(actualUser[0], expectedUser);
*/
        Assert.assertEquals(actualUsersList.get(0), expectedUser);
    }
}
