package dataBaseService;

import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseService {
    public static Logger logger = Logger.getLogger(DataBaseService.class);

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    Connection connection = null;
    Statement statement = null;

    public DataBaseService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.info(e.toString());
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException throwables) {
            logger.info(throwables.toString());
        }

        if (connection != null) {
            logger.info("You successfully connected to database.");
        } else {
            logger.info("Что-то пошло не так");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Statement getStatement() {
        try {
            if (statement == null) {
                statement = getConnection().createStatement();
            }
        } catch (SQLException ex) {
            logger.info("Не удалось создать Statement...");
        }

        return statement;
    }

    public void executeSQL(String sql) {
        try {
            logger.info("Результат выполнения запроса: " + getStatement().execute(sql));
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }

        return null;
    }

    public void closeStatement() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            logger.info("Не удалось закрыть Statement...");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            logger.info(throwables.toString());
        }
    }
}
