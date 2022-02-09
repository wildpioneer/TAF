package tests.dbTests;

import baseEntity.BaseDBTest;
import dbEntities.CustomersTable;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sqlTests extends BaseDBTest {
    public static Logger logger = Logger.getLogger(sqlTests.class);

    @Test
    public void firstTest() {
        logger.info("Test is started...");

        CustomersTable customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createCustomersTable();

        customersTable.addCustomer("Иван", "Иванов", "ivanov@test.com", 28);
        customersTable.addCustomer("Петр", "Петров", "petrov@test.com", 38);
        customersTable.addCustomer("Марина", "Стасевич", "marina@test.com", 23);

        ResultSet rs = customersTable.getCustomers();

        try {
            while (rs.next()) {
                String userid = rs.getString("ID");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                logger.info("userid: " + userid);
                logger.info("firstname: " + firstName);
                logger.info("lastname: " + lastName);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        logger.info("Test is completed...");
    }

    @Test
    public void secondTest() {
        List<Integer> firstArray = new ArrayList<>();
        firstArray.add(10);
        firstArray.add(20);
        firstArray.add(30);

        List<Integer> secondArray = new ArrayList<>();
        secondArray.add(10);
        secondArray.add(20);
        secondArray.add(30);

        Assert.assertTrue(firstArray.containsAll(secondArray));
    }
}
