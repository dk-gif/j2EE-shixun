<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main1.css"/>
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
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
                <li><a href="Front_Page.jsp" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
            	<c:if test="${isLogin != 1 }">
            		<li><a href="reg.jsp">登录</a></li>
                	<li><a href="reg.jsp">注册</a></li>
                </c:if>
                <c:if test="${isLogin == 1 }">
            		<li>尊敬的 ${name.USER_NAME } 你好</li>
                </c:if>
                <li><a href="logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="index.jsp"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                    	<li><a href="user.jsp"><i class="icon-font">&#xe006;</i>个人信息</a></li>
                        <li><a href="/Shixun/manage/admin_product.jsp"><i class="icon-font">&#xe006;</i>图书查看</a></li>
                        <li><a href="/Shixun/manage/admin_cate.jsp"><i class="icon-font">&#xe005;</i>分类查看</a></li>
                        <li><a href="/Shixun/manage/admin_order.jsp"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                        <li><a href="/Shixun/manage/admin_message.jsp"><i class="icon-font">&#xe012;</i>留言管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->