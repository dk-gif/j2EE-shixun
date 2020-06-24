<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <!-- 引入图标字体 -->
    <link rel="stylesheet" href="./fonts/fontawesome-free-5.12.0-web/css/all.css"><!-- 字体 -->
    <link rel="stylesheet" href="./css/main.css">
    <script type="text/javascript" src="js/laydate/laydate.js"></script><!-- 时间js插件 -->
    <script type="text/javascript" src="js/funciton.js"></script><!-- 表单限制器 -->
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
    var ins1 = laydate.render({ //配置对象，引入的时间函数
  		elem: '#test1'
  		,mark: {
    	'0-10-14': '生日'
  		}
  	,done: function(value, date){
    if(date.year === 2020 && date.month === 6 && date.date === 25){ //弹出提示语
      ins1.hint('实训完成之日');
    		}
  		}
	});
    </script>
    <style>
    	.error{/*错误提示样式*/
    		display:inline-block;
    		padding:0px 50px;
    		margin-left:20px;
    		font-size:16px;
    		color:red;
    		background-color:#ffe8e0;
    	}
    </style>
</head>

<body>
    <!-- 创建封装容器 -->
    <div class="container" id="container">

        <!-- 注册页面 -->
        <div class="form-container sign-up-container">
            <form action="register" method="post" onsubmit="return checkForm(this)"><!-- 提交到register这个servlet类中，限制器false就无法提交，为true才能提交 -->
            	<h1>注册</h1>
                <input type="text" name="userName" id="userName" placeholder="账号..." onfocus="Fous(this)" onblur="check(this)"><span></span>
                <input type="text" name="name" id="name" placeholder="昵称..." onfocus="Fous(this)" onblur="check(this)"><span></span>
                <input type="password" name="password" id="password" placeholder="密码...">
                <input type="password" name="repassword" id="repassword" placeholder="确定密码..." onfocus="Fous(this)" onblur="check(this)"><span></span>
                <lable>
                	<input style="width:15px; height:10px; " type="radio" name="sex" value="T" checked="checked" />男
                	<input style="width:15px; height:10px; " type="radio" name="sex" value="F" />女
                </lable>
                <input type="text" name="birthday"  id="test1" placeholder="生日...">
				<input type="text" name="mobile"  placeholder="联系方式...">
                <input type="text" name="address" placeholder="送货地址..." >
                <i style="height:50px;"><input type="text" name="verycode" value="" placeholder="验证码" onfocus="Fous(this)" onblur="check(this)">
                <img src="getCode" style="height:30px;" alt="看不清换一张" onclick="change(this)"></i>
                <button>确定</button>
            </form>
        </div>

        <!-- 登录页面 -->
        <div class="form-container sign-in-container">
            <form action="login" method="post">
                <h1>登录</h1>
                <!-- 公共组件 -->
                <div class="social-container">
                    <a href="#"><i class="fab fa-qq"></i></a>
                    <a href="#"><i class="fab fa-weixin"></i></a>
                    <a href="#"><i class="fab fa-weibo"></i></a>
                </div>
                <input type="text" name="userName" id="userName" placeholder="账号..." >
                <input type="password" name="password" id="password" placeholder="密码...">
                <a href="#" class="forget">忘记密码?</a>
                <button>登录</button>
            </form>
        </div>

        <!-- 覆盖容器 -->
        <div class="overlay-container">
            <div class="overlay">

                <!-- 覆盖左边 -->
                <div class="overlay-penal overlay-left-container">
                    <h1>我的朋友!</h1>
                    <p>
                        快去登录吧！我已经迫不及待了！
                    </p>
                    <button class="ghost" id="signIn">登录</button>
                </div>

                <!-- 覆盖右边 -->
                <div class="overlay-penal overlay-right-container">
                    <h1>欢迎进入图书管理系统</h1>
                    <p> 
                        注册一个心仪的账号，去注册吧！
                    </p>
                    <button class="ghost" id="signUp">注册</button>
                </div>
            </div>
        </div>
    </div>
    <script src="./js/main.js"></script>
</body>
</html>