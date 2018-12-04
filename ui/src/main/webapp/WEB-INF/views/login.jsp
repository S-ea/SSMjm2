<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        #body{
            width: 954px;
            height: 374px;
            margin: 0 auto;
        }
        #img{
            float: left;
            width: 454px;
            height: 100%;
            background-image: url("../../img/register_b.png");
        }
        #form{
            float: left;
            width: 500px;
            height: 100%;
        }
        #head{
            border-top: 4px solid #EA3A3A;
            width: 500px;
            height: 46px;
            background-color: #F9F9F9;
            text-align: center;
            font-size: 16px;
            line-height: 46px;
        }
        #f_body{
            padding: 10px;
        }
        #login{
            overflow: hidden;
        }
        #login label{
            margin: 30px 0 0 0;
            width: 90px;
            height: 50px;
            line-height: 50px;
            text-align: right;
            float: left;
            padding-right: 20px;
            color: #333;
            font-size: 12px;
        }
        #login input{
            margin: 30px 0 0 0;
            float: left;
            margin-right: 50px;
            width: 300px;
            height: 50px;
            box-sizing: border-box;
            border: 1px solid #cdcdcd;
            padding: 5px 10px 5px 10px;
        }
        #login p{
            float: left;
            margin-top: 20px;
            width: 300px;
            text-align: center;
        }
        #login a{
            text-decoration: none;
            font-size: 12px;
        }
    </style>
</head>
<body>
<h2>员工登录</h2>


<div id="body">

    <div id="form">
        <div id="head">个人用户登录</div>
        <div id="f_body">
            <form id="login" action="/main">
                <label for="userName">账号</label><input type="text" id="userName" name="userName" placeholder="请输入用户名"/>
                <label for="passWord">密码</label><input type="password" id="passWord" name="passWord" placeholder="请输入密码"/>
                <label>&nbsp;</label><input type="submit" value="登录" id="login_on" style="background-color: #EB3B3B"/>
                <label>&nbsp;</label><p><a href="zhuce.jsp">免费注册</a></p>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>
