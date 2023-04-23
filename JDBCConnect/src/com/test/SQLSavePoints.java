package com.test;

import java.sql.*;

public class SQLSavePoints {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "Zcl48484848!");
        Statement statement = connection.createStatement();
        ){
            System.out.println("datbase connected");
            
            //this means we have to manually commit to save changes
            //back to database or else nothing will change
            connection.setAutoCommit(false);
            
            statement.executeUpdate("insert into user values ('abc','abc')");
            //save a record point
            Savepoint save = connection.setSavepoint();
            statement.executeUpdate("insert into user values ('b','b')");
            statement.executeUpdate("insert into user values ('c','c')");
            //go back to save points 
            //this means only abc would be added after we commit
            connection.rollback(save);
            connection.commit();

            System.out.println("commited");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
