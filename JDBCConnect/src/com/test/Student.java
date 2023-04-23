package com.test;

public class Student {
    //if we are using reflect to create class
    //we need to  use Integer class and not int
    //Using JAVA reflect classes, we can't use int
    Integer id;
    String name;
    String gender;

    public Student(Integer id, String name, String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public void say(){
        System.out.println("I'm "+name+", ID: "+ id + ", gender: "+gender);
    }
}
