<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: JOKRE
  Date: 2021/5/12
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息展示</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script>
        function del(sid) {
            if (confirm("你真的要删除吗？")){
                window.location.href = "student?flag=deleteStudent&id=" + sid;
            }
        }

        $(function () {
            //全选和反选
            $("#checkall").click(function () {
                var statu = $("#checkall").prop("checked");
                $(".checkone").prop("checked",statu);
            })
            //批量删除
            $("#btn").click(function () {
                //创建数组存放后面循环出来的数据
                var array = new Array();
                //获取选中的checkone的value属性值
                $(".checkone:checked").each(function (index,content) {
                    //获取当前循环的checkone的value属性值，用于后期判断和删除
                    var id = $(content).val();
                    //将得到的id存放在数组中
                    array.push(id);
                });
                if (array.length == 0){
                    alert("未选择学生");
                }else{
                    if (confirm("你真的要删除吗？")){
                        //将数组转换成字符串，join（）将数组中的数据用逗号隔开转换
                        var ids = array.join();
                        //发送批量删除请求
                        window.location.href = "student?flag=deleteAll&ids=" + ids;
                    }
                }
            });
        });
    </script>
</head>
<style>
    .div1{
        margin-top: 100px;
        margin: auto;
        height: 600px;
        width: 500px;
        text-align: center;
        border: 1px black solid;
    }
    .div2{
        margin-top: 20px;
        margin-bottom: 20px;
    }
    .div3{
        height: 50px;
        width: 300px;
        text-align: center;
        margin: auto;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    table{
        border: 1px solid black;
        width: 420px;
        text-align: center;
        margin: auto;
    }
    .img{
        width: 50px;
    }
</style>

<body>
    <div class="div1">
    <h3>学生信息显示</h3>
    <div class="div2">
        <form action="student" method="post">
        <span>姓名：</span>
        <input type="hidden" name="flag" value="getStudentByName">
        <input type="text" name="stuname" value="${sname}">
        <input type="submit" value="查询">
        </form>
    </div>
    <table border="1" cellpadding="3" cellspacing="0">
        <tr>
            <th>
                <input type="checkbox" id="checkall">全选
            </th>
            <th>序号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>头像</th>
            <th>操作</th>
        </tr>
        <c:forEach var="stu" items="${stulist}">
        <tr>
            <td><input type="checkbox" class="checkone" value="${stu.id}"></td>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.sex}</td>
            <td><img class="img" src="http://localhost:8090/photo/student/${stu.photo}"></td>
            <td><a href="javascript:del(${stu.id})">删除 </a> <a href="student?flag=getStudentById&id=${stu.id}"> 修改</a></td>
        </tr>
        </c:forEach>
    </table>
    <div class="div3">
        <a href="student?flag=getStudentByName&stuname=${sname}&page=1">首页</a>
        <a href="student?flag=getStudentByName&page=${pu.prevPage}&stuname=${sname}">上一页</a>
        ${pu.page}/${pu.countPage}
        <a href="student?flag=getStudentByName&page=${pu.nextPage}&stuname=${sname}">下一页</a>
        <a href="student?flag=getStudentByName&page=${pu.countPage}&stuname=${sname}">尾页</a>
        <input style="margin-left: 20px" type="button" value="批量删除" id="btn">
    </div>
    <a href="insert.jsp">点击添加学生</a>
    </div>
</body>
</html>
