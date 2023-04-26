package myBatisTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myBatisTest.entity.Student;

public class ConnectWithUtil {
    public static void main(String[] args) throws FileNotFoundException {
        //using our util to 
        try(SqlSession session = MyBatisUtil.getSession(true)){
            List<Student> list =  session.selectList("selectStudent");
            list.forEach(System.out::println);
        
        }
    }
}

