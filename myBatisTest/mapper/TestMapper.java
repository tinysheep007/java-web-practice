package myBatisTest.mapper;

import java.util.List;

import myBatisTest.entity.Student;
import myBatisTest.entity.Teacher;

public interface TestMapper {
    List<Student> selectStudent();
    List<Student> selectStudentByTeacher(int tid);
    Student getStudentBySid(int sid);
    int addStudent(Student student);
    int deleteStudentBySid(int sid);
    Teacher getTeacherByTid(int tid);
}
