package com.test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginWithoutPrepare {
    //login without prepareStatement could be dangerous
    //because system does not know when to use symbols inside our password as a string
    //or as in a acutal statament
    //for emxaple using 
    //or 1=1 
    //in our input would always give u password that returns true and sucessfully log in

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "Zcl48484848!");
            Statement statement = connection.createStatement();
            Scanner scan = new Scanner(System.in);
            ){
            System.out.println("datbase connected. Time to Login");
            
            //remeber to add backtick around the variables
            //for exmaple user = 'any column name'
            String sql = "select * from user where Userid ='"+scan.nextLine() + "' and Password ='"+scan.nextLine()+"';";
            ResultSet set = statement.executeQuery(sql);

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
