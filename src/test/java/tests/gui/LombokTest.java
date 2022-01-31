package tests.gui;

import baseEntity.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.testng.annotations.Test;

public class LombokTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        User user = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        User user1 = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        System.out.println(user.toString());
        System.out.println(user.equals(user1));
    }
}
