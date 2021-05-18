package tests.ui;

import baseEntities.BaseTest;
import lombok.extern.slf4j.Slf4j;
import models.Project;
import org.testng.annotations.Test;
import steps.LoginSteps;

@Slf4j
public class SmokeTest extends BaseTest {

    @Test
    public void createProject() {
        //Project project = null;

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps
                .openLoginPage()
                .loginWithCorrectCredentials()
                .openDashboardPage(false);

        System.out.println("Все гуд!!!");
/*
                .openAdminProjectsPage(true)
                .openProjectsMenu()
                .createNewProject(project);
*/

    }

    @Test
    public void createProjectWithTypeSingle() {
        log.info("Browser is started....");
    }
}
