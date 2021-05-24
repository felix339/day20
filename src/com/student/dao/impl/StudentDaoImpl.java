package com.student.dao.impl;

import com.student.dao.StudentDao;
import com.student.entity.Student;
import com.student.util.JdbcUtil;
import com.student.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JOKRE
 */
public class StudentDaoImpl implements StudentDao {

    QueryRunner qr = JdbcUtil.getQueryRunner();

    //查询所有学生信息
    @Override
    public List<Student> getAllStudent(){
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";

        list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //添加学生
    @Override
    public int insertStudent(Student stu){
        String sql = "insert into student (name,age,sex,photo) values (?,?,?,?)";
        int rows = 0;
        try {
            rows = qr.update(sql,stu.getName(),stu.getAge(),stu.getSex(),stu.getPhoto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    //删除学生
    @Override
    public int deleteStudent(int id){
        String sql = "delete from student where id = ?";
        int rows = 0;
        try {
            rows = qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    //修改学生
    @Override
    public int updateStudent(Student stu){
        String sql = "update student set name = ?,age = ?,sex = ?, photo = ? where id = ?";
        int rows = 0;
        try {
            rows = qr.update(sql,stu.getName(),stu.getAge(),stu.getSex(),stu.getPhoto(),stu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    //根据学号查找学生
    @Override
    public Student getStudentById(int id){
        String sql = "select * from student where id = ?";
        Student stu = null;
        try {
            stu = qr.query(sql,new BeanHandler<>(Student.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }
    //根据名字模糊查询
    @Override
    public List<Student> getStudentByName(String name,PageUtil pu){
        String sql = "select * from student where name like '%"+ name +"%' limit ?,?";
        List<Student> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //分页查询
    //获取学生数据表条数
    @Override
    public int getCountRows() {
        String sql = "select count(*) from student";
        int rows = 0;
        try {
            rows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    //根据页码分页查询
    @Override
    public List<Student> getStudentByPage(PageUtil pu) {
        String sql = "select * from student limit ?,?";
        List<Student> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //删除选中学生
    @Override
    public int deleteAll(String ids) {
        String sql = "delete from student where id in("+ids+")";
        int rows = 0;
        try {
            rows = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int getCountRowsByName(String name) {
        int countRows = 0;
        String sql = "select count(*) from student where name like '%"+name+"%'";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

}
