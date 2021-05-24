<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: JOKRE
  Date: 2021/5/13
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息修改</title>
</head>
<style>
    .div1{
        padding-top: 100px;
        height: 600px;
        width: 420px;
        margin: auto;
        text-align: center;
    }
    .div2{
        margin: auto;
        height: 500px;
        width: 300px;
        text-align: center;
        padding-top: 30px;
    }
    form{
        height: 320px;
        width: 300px;
        border: 1px solid black;
    }
    .img{
        width: 50px;
    }
</style>
<body>
    <div class="div1">
        <h3>学生信息修改</h3>
        <div class="div2">
        <form style="margin: auto" action="student" method="post" enctype="multipart/form-data">
            <input type="hidden" name="flag" value="updateStudent">
            <input type="hidden" name="stuid" value="${stu.id}">
            <p>姓名：<input type="text" name="stuname" value="${stu.name}"></p>
            <p>年龄：<input type="number" name="stuage" value="${stu.age}"></p>
            <p>性别：
                <input type="radio" name="stusex" value="男" ${stu.sex eq '男'?'checked':''}>男
                <input type="radio" name="stusex" value="女" ${stu.sex eq '女'?'checked':''}>女
            </p>
            <p>
                头像：
                <input type="file" name="stuphoto">
                <img class="img" src="http://localhost:8090/photo/student/${stu.photo}">
                <input type="hidden" name="oldstuphoto" value="${stu.photo}">
            </p>
            <input type="submit" value="修改">
            <input style="margin-left: 20px" type="reset" value="取消">
        </form>
        </div>
    </div>
</body>
</html>
