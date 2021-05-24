package com.student.service;

import com.student.entity.Student;
import com.student.util.PageUtil;

import java.util.List;

public interface StudentService {
    //查询所有学生信息
    public List<Student> getAllStudent();
    //添加学生
    public boolean insertStudent(Student stu);
    //删除学生
    public boolean deleteStudent(int id);
    //修改学生
    public boolean updateStudent(Student stu);
    //根据学号查找学生
    public Student getStudentById(int id);
    //根据名字模糊查询
    public List<Student> getStudentByName(String name,PageUtil pu);
    //分页查询
    public int getCountRows();

    public List<Student> getStudentByPage(PageUtil pu);

    public boolean deleteAll(String ids);

    public int getCountRowsByName(String name);
}
