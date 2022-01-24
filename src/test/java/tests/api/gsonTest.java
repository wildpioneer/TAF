package tests.api;

import baseEntities.BaseApiTest;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User1;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class gsonTest extends BaseApiTest {

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

        Type listType = new TypeToken<ArrayList<User1>>() {
        }.getType();
        List<User1> actualUserList = gson.fromJson(response.getBody().asString(), listType);

        System.out.println(actualUserList.get(0).toString());
        Assert.assertEquals(user, actualUserList.get(0));
    }

}
