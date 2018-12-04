<%--
  Created by IntelliJ IDEA.
  User: Zedd
  Date: 2018-11-09
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登录成功</h2>

<br>
<a href="">后台首页</a>
<a href="">会员管理</a>
<a href="">安全退出</a>

<form action="/del">
    <table width="100%" border="1">
        <tr>
            <th><input type="checkbox" id="chbAll"></th>
            <th>编号</th>
            <th>用户名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>注册时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${user}" var="item">
            <tr>
                <td><input type="checkbox" name="cheid" value="${item.id}"/></td>
                <td>${item.id}</td>
                <td>${item.username}</td>
                <td>${item.phone}</td>
                <td>${item.email}</td>
                <td>${item.udate}</td>
                <td>
                    <a href='#' onclick='selupd(this)'>编辑</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form id="user_cz">
        <label>编号：</label><input type="text" id="id_cz" name="id" readonly="readonly">
        <label>用户名：</label><input type="text" id="userName_cz" name="username"><br/>
        <label>手机号：</label><input type="text" id="phone_cz" name="phone">
        <label>邮箱：</label><input type="email" id="email_cz" name="email"><br/>
        <input type="button" value="修改" onclick="upd()">
    </form>
    <div id="pager"></div>
    <button>删除</button><a href="/files">导出文档</a>
</form>


<script type="text/javascript" src="../../JS/jquery-1.10.2.min.js"></script>
<script>
    function upd() {
        $.ajax({
            url:"upd",
            data:$("#user_cz").serialize(),
            type:"post",
            dataType:"json",
            success:function (data) {
                alert("修改成功！");
            }
        })
    }
    function selupd(obj) {
        var user = $(obj).data("user");
        $("#userName_cz").val(user.username);
        $("#phone_cz").val(user.phone);
        $("#email_cz").val(user.email);
    }

</script>
</body>
</html>
