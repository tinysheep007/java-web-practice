package myBatisTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myBatisTest.entity.Student;
import myBatisTest.mapper.TestMapper;

public class UseMapper {
    public static void main(String[] args) {
        try(SqlSession session = MyBatisUtil.getSession(true)){
            TestMapper mapper = session.getMapper(TestMapper.class);
            mapper.selectStudent().forEach(System.out::println);
            
            // System.out.println(mapper.getStudentBySid(102851));;
            
            //System.out.println(mapper.addStudent(new Student().setName("kai").setGender("F").setSid(20)));
        
            // System.out.println(mapper.deleteStudentBySid(20));
        }
    }
   
}
