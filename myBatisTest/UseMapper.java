package myBatisTest;
import org.apache.ibatis.session.SqlSession;

import myBatisTest.entity.Student;
import myBatisTest.mapper.TestMapper;

public class UseMapper {
    public static void main(String[] args) {
        try(SqlSession session = MyBatisUtil.getSession(true)){
            TestMapper mapper = session.getMapper(TestMapper.class);
            //mapper.selectStudent().forEach(System.out::println);
            
            // System.out.println(mapper.getStudentBySid(102851));;
            
            // System.out.println(mapper.addStudent(new Student().setName("kai").setGender("F").setSid(20)));
        
            // System.out.println(mapper.deleteStudentBySid(20));

            // System.out.println(mapper.getTeacherByTid(1));

            mapper.selectStudentByTeacher(1).forEach(System.out::println);
        }
    }
   
}
