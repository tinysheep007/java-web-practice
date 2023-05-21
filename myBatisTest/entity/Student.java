package myBatisTest.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student {
    //in the database is Sid, so we must use resultMap inside 
    //the TestMapper.xml
    int sid;
    String Name;
    String Gender;
    Teacher teacher;

    // it will be printed everytime when student is made
    public Student(){
        System.out.println("i am constructed");
    }
}
