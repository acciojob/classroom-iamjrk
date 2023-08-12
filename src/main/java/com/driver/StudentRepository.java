package com.driver;

import com.driver.Model.Student;
import com.driver.Model.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StudentRepository
{
    HashSet<Student> studentHashSet=new HashSet<>();
    HashSet<Teacher> teacherHashSet=new HashSet<>();
    HashMap<String,List<String>> teacherStudentMap=new HashMap<>();


    public String addStudent(Student student)
    {
        if(studentHashSet.contains(student))
        {
            return "Failed";
        }
        studentHashSet.add(student);
        return "Success";
    }

    public String addTeacher(Teacher teacher)
    {
        if(teacherHashSet.contains(teacher))
            return "Failed";
        teacherHashSet.add(teacher);
        return "Success";
    }

    public String addStudentTeacher(String student, String teacher)
    {
        if(!teacherStudentMap.containsKey(student))
        {
            List<String>list=new ArrayList<>();
            list.add(student);
            teacherStudentMap.put(teacher,list);
            return "Success";
        }
        return "Failed";
    }

    public Student getStudentByName(String name)
    {
        for(Student student:studentHashSet)
        {
            if(student.getName().equals(name))return student;
        }
        return null;
    }

    public Teacher getTeacherByName(String name)
    {
        for (Teacher teacher:teacherHashSet)
        {
            if(teacher.getName().equals(name))return teacher;
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher)
    {
        List<String>list=new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher))
        {
            list=teacherStudentMap.get(teacher);
        }
        return list;
    }

    public List<String> getAllStudents()
    {
        List<String>list=new ArrayList<>();
        for(Student student:studentHashSet)
        {
            list.add(student.getName());
        }
        return list;
    }

    public void deleteTeacherByName(String teacher)
    {
        Teacher teacher1 = null;
        for(Teacher teacher2:teacherHashSet)
        {
            if(teacher2.getName().equals(teacher))
            {
                teacher1=teacher2;
                break;
            }
        }
        if(teacher1!=null)
        {
            teacherHashSet.remove(teacher1);
        }
        List<String>studentList = teacherStudentMap.get(teacher);
        for(Student student:studentHashSet)
        {
            if(studentList.contains(student.getName()))
            {
                studentHashSet.remove(student);
            }
        }
        teacherStudentMap.remove(teacher);
    }

    public List<String> deleteAllTeacherAndStudent()
    {
        List<String>list=new ArrayList<>();
        for(Teacher teacher:teacherHashSet)
        {
            list.add(teacher.getName());
        }
        return list;
    }
}
