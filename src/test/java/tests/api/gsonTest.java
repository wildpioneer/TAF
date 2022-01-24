package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User1;
import org.testng.Assert;
import org.testng.annotations.Test;

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
