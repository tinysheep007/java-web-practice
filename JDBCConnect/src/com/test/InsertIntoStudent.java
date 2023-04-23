package com.test;
import java.sql.*;

public class InsertIntoStudent {
    public static void main(String[] args) {
        // connect to JDBC through Driver manager
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root",
                "Zcl48484848!");
                // create a sql object to excute our commands
                Statement statement = connection.createStatement();) {
                    System.out.println("database connected");
                    //result will be stored in ResultSet
                    int i = statement.executeUpdate("insert into student values(4,'andy','M')");
                    
                    //print out result
                    System.out.println("updated "+ i + " lines");
                    
                    

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
