package helpers.project;

import baseEntities.BaseHelper;
import configuration.UserType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.Project;
import utils.Endpoints;
import utils.ObjectUtil;

@Slf4j
public class ProjectHelper extends BaseHelper {
    Response response;

    /**
     * Add a project to the app
     *
     * @param project Project model
     * @return Project
     */
    public Project add(Project project) {
        response = restManager.post(Endpoints.ADD_PROJECT, null, UserType.ADMIN, ObjectUtil.getJsonFromObject(project, Project.class));
        return gson.fromJson(response.asString(), Project.class);
    }

    /**
     * Get a project by ID
     *
     * @param id project's id
     * @return Project
     */
    public Project getProject(int id) {
        response = restManager.get(Endpoints.GET_PROJECT + id, null, UserType.ADMIN, "");
        return gson.fromJson(response.asString(), Project.class);
    }

    public Response getResponse() {
        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}
