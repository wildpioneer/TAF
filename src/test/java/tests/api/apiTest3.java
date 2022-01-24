package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import models.ProjectSimple;
import models.ProjectTypes;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class apiTest3 extends BaseApiTest {
    int projectID;

    @Test
    public void getAllUsers1() {
        String endpoint = "/index.php?/api/v2/get_users";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject1() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project project = Project.builder()
                .name("PR01")
                .projectMode(ProjectTypes.SINGLE_SUITE_MODE)
                .build();

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"suite_mode\": %d\n" +
                        "}", project.getName(), project.getProjectMode()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject2() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project project = Project.builder()
                .name("PR02")
                .projectMode(ProjectTypes.MULTIPLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getProjectMode());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3() {
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectSimple project = new ProjectSimple();
        project.setName("PR03");
        project.setSuite_mode(ProjectTypes.MULTIPLE_SUITE_MODE);

        given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject4() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project project = Project.builder()
                .name("PR04")
                .projectMode(ProjectTypes.SINGLE_SUITE_BASELINES)
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

    }

    @Test(dependsOnMethods = "addProject4")
    public void updateProject1() {
        String endpoint = "index.php?/api/v2/update_project/{project_id}";

        Project project = Project.builder()
                .name("PR04_UPD")
                .announcement("Test!!!")
                .isShowAnnouncement(true)
                .isCompleted(true)
                .build();

        Response json = given()
                .pathParam("project_id", projectID)
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    @Test(dependsOnMethods = "updateProject1")
    public void deleteProject1() {
        String endpoint = "index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
