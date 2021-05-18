package tests.api;

import baseEntities.BaseApiTest;
import helpers.project.ProjectHelper;
import lombok.extern.slf4j.Slf4j;
import models.Project;
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
                {new Project()
                        .setName("test")
                        .setProjectMode(1)},
                {new Project()
                        .setName("test1")
                        .setProjectMode(2)}
        };
    }

    @Test(dataProvider = "data-provider")
    public void addProjectTest(Project project) {
        projectsList.add(projectHelper.add(project));
    }

    @Test(dataProvider = "data-provider")
    public void getProjectTest(Project project) {
        Project tmpProject = projectsList.stream().filter(c -> c.getName().equals(project.getName())).findFirst().get();
        log.info(tmpProject.toString());
        Project actualProject = projectHelper.getProject(tmpProject.getId());
        log.info(actualProject.toString());
        Assert.assertEquals(tmpProject, actualProject);
    }
}
