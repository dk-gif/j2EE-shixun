<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用图书管理系统</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                	<a href="admin_douserselect"><i class="icon-font">&#xe006;</i>查看用户</a>
                    <a href="admin_useradd.jsp"><i class="icon-font">&#xe001;</i>新增用户</a>
                    <a href="#"><i class="icon-font">&#xe005;</i>新增图书分类</a>
                    <a href="#"><i class="icon-font">&#xe048;</i>新增图书</a>
                    <a href="#"><i class="icon-font">&#xe01e;</i>管理评论</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">win</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">tomcat</span>
                    </li>   
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>