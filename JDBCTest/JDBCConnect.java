package JDBCTest;

import java.sql.*;
import java.sql.SQLException;

public class JDBCConnect {
    public static void main(String[] args) {
        // connect to JDBC through Driver manager
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root",
                "Zcl48484848!");
                // create a sql object to excute our commands
                Statement statement = connection.createStatement();) {
            ResultSet set = statement.executeQuery("SELECT * FROM student");
            while (set.next()) {
                System.out.println(set.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}