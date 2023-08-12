package com.driver;

import com.driver.Model.Student;
import com.driver.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student)
    {
        String s=studentRepository.addStudent(student);
        return s;
    }

    public String addTeacher(Teacher teacher)
    {
        String s=studentRepository.addTeacher(teacher);
        return s;
    }

    public String addStudentTeacherPair(String student, String teacher)
    {
        String s =studentRepository.addStudentTeacher(student,teacher);
        return s;
    }

    public Student getStudentByName(String name)
    {
        return studentRepository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name)
    {
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher)
    {
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents()
    {
        List<String>list=studentRepository.getAllStudents();
        return list;
    }

    public void deleteTeacherByName(String teacher)
    {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeacherAndStudent()
    {
        List<String>teacherList=studentRepository.deleteAllTeacherAndStudent();
        for(String s : teacherList)
        {
            deleteTeacherByName(s);
        }
    }
}
