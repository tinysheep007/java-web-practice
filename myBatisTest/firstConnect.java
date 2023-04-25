package myBatisTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class firstConnect {
    public static void main(String[] args) throws FileNotFoundException {
        // 1 SqlSessionFactory can be made from 1 SqlSessionFactoryBuilder
        //then we make a SqlSession from SqlSessionFactory
        //note that 1 sql session factory can make inifnite amount of sessions
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("mybatis-config.xml"));
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            List<Student> list =  session.selectList("selectStudent");
            list.forEach(System.out::println);
        
        }
    }
}
