package tests.api;

import baseEntities.BaseApiTest;
import helpers.project.ProjectHelper;
import lombok.extern.slf4j.Slf4j;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class projectsTest extends BaseApiTest {
    ProjectHelper projectHelper = new ProjectHelper();
    List<Project> projectsList = new ArrayList<>();

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Project[][]{
                {Project.builder()
                        .name("test")
                        .projectMode(1)
                        .build()},
                {Project.builder()
                        .name("test1")
                        .projectMode(2)
                        .build()}
        };
    }

    @Test(dataProvider = "data-provider")
    public void addProjectTest(Project project) {
        projectsList.add(projectHelper.add(project));

        Assert.assertEquals(projectHelper.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(dataProvider = "data-provider")
    public void getProjectTest(Project project) {
        Project expectedProject = projectsList.stream()
                .filter(c -> c.getName().equals(project.getName()))
                .findFirst().get();

        Project actualProject = projectHelper.getProject(expectedProject.getId());

        Assert.assertEquals(projectHelper.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(actualProject, expectedProject);
    }
}
