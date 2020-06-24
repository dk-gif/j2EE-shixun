<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入一个常用的jar包，用来对前端页面动态访问 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span>
		</div>
	</div>
	<div class="result-wrap">
		<form action="#" id="myform" method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="admin_docateadd"><i class="icon-font"></i>新增分类</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th>ID</th>
						<th>分类名称</th>
						<th>操作</th>
					</tr>
					<c:forEach var="cate" items="${catelist }">
						<c:if test="${cate.CATE_PARTENR_ID == 0}">
							<!-- 先遍类,跟分类 -->
							<tr>
								<td>${cate.CATE_ID }</td>
								<td>${cate.CATE_NAME}</td>
								<td><a href="admin_tocateupdate?id=${cate.CATE_ID }">修改</a>&nbsp;<a href="javascript:catedel(${cate.CATE_ID});">删除</a></td>
							</tr>
							<c:forEach var="zcate" items="${catelist }">
								<c:if test="${zcate.CATE_PARTENR_ID == cate.CATE_ID}">
									<!-- 在编列非跟 分类 非跟分类的CATE_PARTENR_ID等于cate.CATE_ID -->
									<tr>
										<td>${zcate.CATE_ID }</td>
										<td>|-----------------------${zcate.CATE_NAME}</td>
										<td><a href="admin_tocateupdate?id=${zcate.CATE_ID }">修改</a>&nbsp;<a href="javascript:catedel(${zcate.CATE_ID});">删除</a></td>
									</tr>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
					<script>
                        	function catedel(id){//提示框confirm
                        		if(confirm("请谨慎删除分类？")){
                        			location.href="admin_docatedel?id="+id;
                        		}
                        	}                    	
                        </script>
				</table>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>