package myBatisTest;
import org.apache.ibatis.session.SqlSession;

import myBatisTest.entity.Student;
import myBatisTest.mapper.TestMapper;

public class UseMapper {
    public static void main(String[] args) {
        try(SqlSession session = MyBatisUtil.getSession(true)){
            TestMapper mapper = session.getMapper(TestMapper.class);
            // print out every student
            // mapper.selectStudent().forEach(System.out::println);
            
            // return only 1 student whos sid is given
            // System.out.println(mapper.getStudentBySid(102851));;
            
            // add a student with the help of chaining in LomBok
            // System.out.println(mapper.addStudent(new Student().setName("kai").setGender("F").setSid(20)));
        
            // System.out.println(mapper.deleteStudentBySid(20));

            // System.out.println(mapper.getTeacherByTid(1));

            // mapper.selectStudentByTeacher(1).forEach(System.out::println);
            
            // using dynamic SQL the logic is in TestMapper.xml
            // mapper.selectStudentWithDynamicSQL(102851).forEach(System.out::println);;
        }
    }
   
}
