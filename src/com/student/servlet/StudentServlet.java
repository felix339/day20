package com.student.servlet;

import com.student.dao.StudentDao;
import com.student.dao.impl.StudentDaoImpl;
import com.student.entity.Student;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;
import com.student.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
@MultipartConfig
@WebServlet("/student")
public class StudentServlet extends BaseServlet {
    StudentService ss = new StudentServiceImpl();

    //显示学生
//    protected void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Student> list = ss.getAllStudent();
//        request.setAttribute("stulist", list);
//        request.getRequestDispatcher("select.jsp").forward(request, response);
//    }

    //分页显示学生
    protected void getStudentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int countRows = ss.getCountRows();
        PageUtil pu = new PageUtil(page,countRows);
        List<Student> list = ss.getStudentByPage(pu);
        request.setAttribute("stulist", list);
        request.setAttribute("pu",pu);
        request.getRequestDispatcher("select.jsp").forward(request, response);
    }

    //添加学生
    protected void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("stuname");
        String age = request.getParameter("stuage");
        String sex = request.getParameter("stusex");
        //图片处理
        Part part = request.getPart("stuphoto");
        //获取图片名
        String cd = part.getHeader("content-disposition");
        String sphoto = cd.substring(cd.lastIndexOf("=") + 2, cd.length()-1);
        String path = "F:\\study\\work\\javaWeb\\JavaWeb\\photo\\student";
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        part.write(path + "/" + UUID.randomUUID() + sphoto);
        //新数据插入数据库
        Student stu = new Student(name,Integer.valueOf(age),sex,sphoto);
        boolean res = ss.insertStudent(stu);
        if (res){
            response.sendRedirect("student?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("添加失败，请稍后重试！");
            out.close();
        }
    }
    //删除学生
    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean res = ss.deleteStudent(Integer.valueOf(id));
        if (res){
            response.sendRedirect("student?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("删除失败，请稍后重试！");
            out.close();
        }
    }
    //删除选中学生
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        boolean res = ss.deleteAll(ids);
        if (res){
            response.sendRedirect("student?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("删除失败，请稍后重试！");
            out.close();
        }
    }
    //回显学生
    protected void getStudentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Student stu = ss.getStudentById(Integer.valueOf(id));
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
    //修改学生
    protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("stuid");
        String name = request.getParameter("stuname");
        String age = request.getParameter("stuage");
        String sex = request.getParameter("stusex");
        //图片的处理
        Part part = request.getPart("stuphoto");
        //获取图片名
        String sphoto = "";
        String cd = part.getHeader("content-disposition");
        String fileName = cd.substring(cd.lastIndexOf("=") + 2, cd.length()-1);
        if ("".equals(fileName)){
            //没有选择图片，不修改图片
            sphoto = request.getParameter("oldstuphoto");
        }else{
            //选择了图片，要修改图片
            sphoto = fileName;
            String path = "F:\\study\\work\\javaWeb\\JavaWeb\\photo\\student";
            File file = new File(path);
            if (!file.exists()){
                file.mkdirs();
            }
            part.write(path + "/" + UUID.randomUUID() + sphoto);
        }
        Student stu = new Student(Integer.valueOf(id),name,Integer.valueOf(age),sex,sphoto);
        boolean res = ss.updateStudent(stu);
        if (res){
            response.sendRedirect("student?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("修改失败，请稍后重试！");
            out.close();
        }
    }
    //模糊查询
    protected void getStudentByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("stuname");
        String page = request.getParameter("page");
        int countRows = ss.getCountRowsByName(name);
        PageUtil pu = new PageUtil(page,countRows);
        List<Student> stu = ss.getStudentByName(name,pu);
        request.setAttribute("stulist",stu);
        request.setAttribute("pu",pu);
        request.setAttribute("sname",name);
        request.getRequestDispatcher("select.jsp").forward(request,response);
    }

}
