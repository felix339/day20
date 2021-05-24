package com.student.service.impl;

import com.student.dao.StudentDao;
import com.student.dao.impl.StudentDaoImpl;
import com.student.entity.Student;
import com.student.service.StudentService;
import com.student.util.PageUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao sd = new StudentDaoImpl();

    @Override
    public List<Student> getAllStudent() {
        List<Student> list = sd.getAllStudent();
        return list;
    }

    @Override
    public boolean insertStudent(Student stu) {
        boolean res = true;
        int rows = sd.insertStudent(stu);
        if (rows == 0){
            res = false;
        }
        return res;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean res = true;
        int rows = sd.deleteStudent(id);
        if (rows == 0){
            res = false;
        }
        return res;
    }

    @Override
    public boolean updateStudent(Student stu) {
        boolean res = true;
        int rows = sd.updateStudent(stu);
        if (rows == 0){
            res = false;
        }
        return res;
    }

    @Override
    public Student getStudentById(int id) {
        Student stu = sd.getStudentById(id);
        return stu;
    }

    @Override
    public List<Student> getStudentByName(String name,PageUtil pu) {
        List<Student> list = sd.getStudentByName(name,pu);
        return list;
    }

    @Override
    public int getCountRows() {
        return sd.getCountRows();
    }

    @Override
    public List<Student> getStudentByPage(PageUtil pu) {
        return sd.getStudentByPage(pu);
    }

    @Override
    public boolean deleteAll(String ids) {
        boolean res = true;
        int rows = sd.deleteAll(ids);
        if (rows == 0){
            res = false;
        }
        return res;
    }

    @Override
    public int getCountRowsByName(String name) {
        return sd.getCountRowsByName(name);
    }
}
