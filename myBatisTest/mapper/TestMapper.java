package myBatisTest.mapper;

import java.util.List;

import myBatisTest.entity.Student;

public interface TestMapper {
    List<Student> selectStudent();
    Student getStudentBySid(int sid);
    int addStudent(Student student);
    int deleteStudentBySid(int sid);
}
