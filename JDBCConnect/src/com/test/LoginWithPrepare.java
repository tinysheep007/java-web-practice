package com.test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginWithPrepare {
    //by using PrepareStatement and setString to login
    //the system would add backticks around our input so that
    //all input would be like 'input'
    //considered as a singular string
    //any symbols in side would be changed to a regular string
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "Zcl48484848!");
        //we can prepare the statement to protect from using hacks like
        //or 1=1;
        //to hack and fake into our database     
        PreparedStatement statement = connection.prepareStatement("select * from user where Userid=? and Password = ?;");
            Scanner scan = new Scanner(System.in);
        ){
            System.out.println("datbase connected. Time to Login");
            //note index start at 1 when replacing ? in the prepared sql sentence
            
            statement.setString(1, "tinysheep007");
            statement.setString(2, "Zcl48484848!");

            //uncomment this if u want to choose ur userid and pass
            // statement.setString(1, scan.nextLine());
            // statement.setString(2, scan.nextLine());

            ResultSet set = statement.executeQuery();

            if(set.next()){
                System.out.println("User "+set.getString("Userid")+" login success!");
            }else{
                System.out.println("login failed!");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
