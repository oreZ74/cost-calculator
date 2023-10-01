package kosten_app;

import java.sql.*;

public class DB_Util {

    // Defining the JDBC_DRIVER:
    private final String JDBC_DRIVER = "jdbc:sqlite:";
    private Connection connection;

    // Constructor:
    public DB_Util(String dbName) throws SQLException {
        dbConnect(dbName);
    }

    // Connect to db:
    public void dbConnect(String dbName) throws SQLException {
        String url = JDBC_DRIVER + dbName;
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established!");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }

    // Close connection:
    public void dbDisconnect() throws SQLException {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
