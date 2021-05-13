package helpers.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Project;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class ProjectHelper {
    static Logger logger = Logger.getLogger(ProjectHelper.class);

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public ProjectHelper() {
    }

    public String getProjects() {
        return given()
                .when()
                .get("index.php?/api/v2/get_projects")
                .body()
                .asString();
    }

    public Project getProject(int projectId) {

        String body = given()
                .when()
                .get("index.php?/api/v2/get_project/" + projectId)
                .body()
                .asString();

        return gson.fromJson(body, Project.class);
    }
}
