<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">个人信息</span>
		</div>
	</div>
	<div class="result-wrap">
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>手机</th>
						<th>操作</th>
					</tr>
						<tr>
							<td>${name.USER_ID }</td>
							<td>${name.USER_NAME }</td>
							<td>${name.USER_MOBILE }</td>
							<td><a class="link-update" href="/Shixun/ToOrdinaryUpadate?id=${name.USER_ID}">修改</a></td>
						</tr>
				</table>		
			</div>
	</div>
</div>
<!--/main-->
</div>