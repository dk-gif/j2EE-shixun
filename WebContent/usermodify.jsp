<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="menu.jsp"%>
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i> <a href="index.jsp">首页</a>
			<span class="crumb-step">&gt;</span> <a class="crumb-name" href="user.jsp">个人信息</a> 
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content"><!-- 一定要注意name的值与admin_douserupdate中获得的值名字一模一样，错一个就获得不了 -->
			<form action="/Shixun/DoOrdinaryUpdate" method="post" id="myform" name="myform" onsubmit="return checkForm(this)">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>账户名：</th>
							<td style="color:red;">谨慎修改个人信息<input class="common-text required" id="title"
								name="userName" size="50" value="${name.USER_ID }" type="hidden">
								<span></span>
							</td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>昵称：</th>
							<td><input class="common-text required" id="title"
								name="name" size="50" value="${name.USER_NAME }" type="text" onfocus="Fous(this)" onblur="check(this)">
								<span></span>
							</td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>登录密码：</th>
							<td><input class="common-text required" id="title"
								name="password" size="50" value="${name.USER_PASSWORD }" type="text" required> 
							</td>
						</tr>
						<tr>
							<th>性别：</th>
							<td><input type="radio" name="sex" value="T" ${name.USER_SEX=='T'?'checked':'' }>男 
								<input type="radio" name="sex" value="F" ${name.USER_SEX=='F'?'checked':'' }>女
							</td>
						</tr>
						<tr>
							<th>出生日期</th>
							<td><input class="common-text required" id="test1"
								name="birthday" size="50" value="${name.USER_BIRTHDAY }" type="text" required>
							</td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>电子邮箱：</th>
							<td><input class="common-text required" id="title"
								name="email" size="50" value="${name.USER_EMAIL }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>手机号：</th>
							<td><input class="common-text required" id="title"
								name="mobile" size="50" value="${name.USER_MOBILE }" type="text" required>
							</td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>地址：</th>
							<td><input class="common-text required" id="title"
								name="address" size="50" value="${name.USER_ADDRESS }" type="text">
							</td>
						</tr>
						<tr>
							<th></th>
							<td><input class="btn btn-primary btn6 mr10" value="提交"
								type="submit"> <input class="btn btn6"
								onClick="history.go(-1)" value="返回" type="button"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</div>
<!--/main-->
</div>
</body>
</html>