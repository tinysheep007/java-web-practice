package com.test;

import java.lang.reflect.Constructor;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // connect to JDBC through Driver manager
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root",
                "Zcl48484848!");
                // create a sql object to excute our commands
                Statement statement = connection.createStatement();) {
                    System.out.println("database connected");
                    //result will be stored in ResultSet
                    ResultSet set = statement.executeQuery("SELECT * FROM student;");
                    //print out result
                    while (set.next()) {
                        //note column index start at 1
                        //we can use index or name to plug into the parameter for column label
                        //Student s = new Student(set.getInt("Sid"), set.getString("Name"), set.getString("Gender"));
                        Student s = convert(set, Student.class);
                        s.say();
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //using relfect to create class
    public static <T> T convert(ResultSet set, Class<T> clazz){
        try{
            //get the class constructor
            Constructor<T> constructor = clazz.getConstructor(clazz.getConstructors()[0].getParameterTypes());
            //get the parameter types for the constrcutor
            Class<?>[] param = constructor.getParameterTypes();
            //create array to store all the data from result set
            Object[] object = new Object[param.length];
            //loop
            for(int i=0;i<param.length;i++){
                //since indedx at 1 NOT 0
                object[i] = set.getObject(i+1);
                //if parameter class DOES NOT match throw SQL error
                if(object[i].getClass() != param[i]){
                    throw new SQLException("wrong type cast: "+object[i].getClass()+" -> "+param[i]);
                }
            }
            return constructor.newInstance(object);

        }catch(ReflectiveOperationException | SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}

