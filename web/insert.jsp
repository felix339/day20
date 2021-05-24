<%--
  Created by IntelliJ IDEA.
  User: JOKRE
  Date: 2021/5/13
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<style>
    div{
        padding-top: 100px;
        height: 600px;
        width: 420px;
        margin: auto;
        text-align: center;
    }
    form{
        height: 230px;
        width: 300px;
        border: 1px solid black;
    }
</style>
<body>
    <div>
    <h3>学生信息添加</h3>
    <form style="margin: auto" action="student" method="post" enctype="multipart/form-data">
        <input type="hidden" name="flag" value="insertStudent">
        <p>姓名：<input type="text" name="stuname"></p>
        <p>年龄：<input type="number" name="stuage"></p>
        <p>性别：<input type="radio" name="stusex" value="男">男<input type="radio" name="stusex" value="女">女</p>
        <p>头像：<input type="file" name="stuphoto"></p>
        <input type="submit" value="添加">
        <input style="margin-left: 20px" type="reset" value="重置">
    </form>
    </div>
</body>
</html>
