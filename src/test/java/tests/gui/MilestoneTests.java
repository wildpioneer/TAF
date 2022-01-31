package tests.gui;

import baseEntity.BaseTest;
import models.Milestone;
import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;

public class MilestoneTests extends BaseTest {

    @Test
    public void test1() {
        Project project = Project.builder().build();
        User user = User.builder().build();
        Milestone milestone = new Milestone();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        projectSteps.addProject(project);
        milestoneSteps.createMilestone(project, milestone);
    }
}
