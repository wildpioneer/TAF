package dbEntities;

import dataBaseService.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class CustomersTable {
    public static Logger logger = Logger.getLogger(CustomersTable.class);

    DataBaseService dataBaseService;

    public CustomersTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void dropTable() {
        logger.info("Удаляем customers таблицу");
        String dropTableCustomersSQL = "DROP TABLE customers;";

        dataBaseService.executeSQL(dropTableCustomersSQL);
    }

    public void createCustomersTable() {
        logger.info("Создаем customers таблицу");

        String createTableSQL = "CREATE TABLE customers (" +
                "ID SERIAL PRIMARY KEY, " +
                "FirstName CHARACTER VARYING(30), " +
                "LastName CHARACTER VARYING(30), " +
                "Email CHARACTER VARYING(30), " +
                "Age INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void addCustomer(String firstName, String lastName, String email, int age) {
        logger.info("Добавляем запись в таблицу");

        String insertTableSQL = "INSERT INTO public.customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', " + age + ");";

        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getCustomers() {
        String selectSQL = "SELECT * FROM public.customers ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }
}
