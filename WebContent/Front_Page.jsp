<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
		*{
			margin: 0;
			padding: 0;
		}
		body{
			background-color: #000;
			text-align: center;
			text-align: center;
		}
        h1{
	        margin-top: 50px; 
	        font-size: 100px;
	        display: inline-block; /*改变块级默认display：black*/
	        color: rgba(255,255,255,.3);
	        background: linear-gradient(130deg,rgba(255,255,255,0) 
	        	100px,rgba(255,255,255,1) 140px,rgba(255,255,255,0)120px);
	        background-repeat: no-repeat; /*不重复*/
	        -webkit-background-clip:text; /*设置为文字背景颜色*/
        }
        h2{
	        font-size: 30px;    
	        color: rgba(255,255,255,.3);
	        -webkit-background-clip:text; /*设置为文字背景颜色*/
        }
        .nav{
        	width: 100%;
        	height: 100px;
        	overflow: hidden;
        }
        .nav > .nav_left{
        	float: left;
        }
        .nav > .nav_right > ul{
        	float: right;
        }
        .nav > .nav_right > ul > li{
        	float: left;
        	margin: 0 40px;
        }
        a{
        	text-decoration: none;
        	color: red;
        	font-size: 50px;
        }
	</style>
	<script type="text/javascript">
		window.onload = function(){
			let h1 = document.getElementsByTagName("h1")[0];
			let h2 = document.getElementsByTagName("h2")[0];
			alert("没有做完敬请期待");
			let flag = -200;
			setInterval(function(){
				if(flag==800)
				{
					flag = -200;
				}
				flag += 10;
				h1.style.backgroundPosition = flag+'px';
			},30);
		}
	</script>
</head>
<body>
	<div class="nav">
		<div class="nav_left">
			<h2>logo</h2>
		</div>
		<div class="nav_right">
			<ul>
				<li><a href="reg.jsp">登录</a></li>
				<li><a href="reg.jsp">注册</a></li>
			</ul>
		</div>
	</div>
	<h1>图书管理系统前台</h1>
</body>
</html>