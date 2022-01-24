package baseEntities;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.UserSimple;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    public UserSimple master;
    public UserSimple tester;

    @BeforeTest
    public void setupTest() {
        org.apache.log4j.BasicConfigurator.configure();

        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());

        master = new UserSimple.Builder()
                .withName("AQA7 Master")
                .withEmail("atrostyanko+0401@gmail.com")
                .withIsActive(true)
                .build();

        tester = new UserSimple.Builder()
                .withName("AQA7 Tester")
                .withEmail("atrostyanko+0401@gmail.com")
                .withIsActive(true)
                .build();

        System.out.println("Setup is done.");
    }
}
