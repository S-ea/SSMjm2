<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        #body{
            width: 1000px;
            height: 470px;
            margin: 100px auto;
            box-shadow: 0px 1px 9px 0px rgba(0,0,0,0.3);
        }
        #head{
            border-top: 4px solid #EA3A3A;
            width: 1000px;
            height: 46px;
            background-color: #F9F9F9;
            text-align: center;
            font-size: 16px;
            line-height: 46px;
        }
        #text{
            padding: 15px;
            box-sizing: border-box;
            width: 1000px;
            height: 420px;
        }
        #ul{
            float: left;
            list-style: none;
            overflow: hidden;
        }
        #ul li{
            width: 620px;
            height: 56px;
        }
        #ul li label{
            width: 90px;
            text-align: right;
            float: left;
            padding-right: 20px;
            color: #333;
            font-size: 12px;
            line-height: 56px;
        }
        #ul li input{
            display: block;
            border-radius: 2px;
            border: 1px solid #cdcdcd;
            float: left;
            background-color: #ffffff;
        }
        #ul li span{
            color: #e83535;
        }
        #ul li p{
            float: left;
            margin-top: 18px;
        }
        #ul li p a{
            text-decoration: none;
        }
        .input{
            width: 300px;
            height: 32px;
            padding: 5px 10px;
            margin: 12px 0;
            font: 500 14px "微软雅黑";
            color: #666;
            box-sizing: border-box;
        }
        #img{
            float: left;
            width: 350px;
            height: 380px;
            margin-top: 10px;
            background-image: url("../img/register_b.png");
        }
    </style>
</head>
<body>



<div id="body">
    <div id="head">个人用户注册</div>
    <div id="text">
        <form id="register" action="/addUsers">
            <ul id="ul">
                <li>
                    <label for="username"><span></span>用户名</label><input class="input" type="text" id="username" name="username" placeholder="请输入用户名"/>
                </li>
                <li>
                    <label for="phone"><span></span>手机号</label><input class="input" type="text" id="phone" name="phone" placeholder="请输入手机号"/>
                </li>
                <li>
                    <label for="password"><span></span>密码</label><input class="input" type="password" id="password" name="password" placeholder="请输入密码"/>
                </li>
                <li>
                    <label for="password1"><span></span>确认密码</label><input class="input" type="password" id="password1" name="password1" placeholder="请确认密码"/>
                </li>
                <li>
                    <label for="email">绑定邮箱</label><input class="input" type="email" id="email" name="email" placeholder="请输入需要绑定的邮箱地址"/>
                </li>
                <li>
                    <label>&nbsp;</label><input style="width: 18px;height: 18px; margin-top: 19px;" type="checkbox" id="ckd" checked="checked"><p style="font-size: 14px">我同意&nbsp;<a href="#">《服务协议》</a></p>
                </li>
                <li>
                    <label>&nbsp;</label><input class="input" style="background-color: #e83535;border-color: #e83535;color: #ffffff;" type="submit" id="register_on" value="注册">
                </li>
                <li>
                    <label>&nbsp;</label><p style="font-size: 12px"><a href="login">拥有账号，直接登录</a></p>
                </li>
            </ul>
        </form>
        <div id="img"></div>
    </div>
</div>
<script>

</script>


</body>
</html>
