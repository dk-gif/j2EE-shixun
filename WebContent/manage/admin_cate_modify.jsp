<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
    <!--/sidebar 用户添加界面-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_docateselect">分类管理</a><span class="crumb-step">&gt;</span><span>新增分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/Shixun/manage/admin_tocateupdate" method="post" id="myform" name="myform">
                	<input type="hidden" name="id" value="${cate1.CATE_ID }"><!-- 把id传过去，但不让他显示 -->
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>父级分类：</th>
                                <td>
                                    <select class="common-text required" name="parentId">
                                    <option value="0">总分类</option>
                                    	<c:forEach var="cate" items="${catelist }">
                                    		<c:if test="${cate.CATE_PARTENR_ID == 0 }">
                                    			<c:if test="${cate1.CATE_PARTENR_ID == cate.CATE_ID }">
                                    				<option value="${cate.CATE_ID }" selected="selected" >${cate.CATE_NAME }</option>
                                    			</c:if>
                                    			<c:if test="${cate1.CATE_PARTENR_ID != cate.CATE_ID }">
                                    				<option value="${cate.CATE_ID }">${cate.CATE_NAME }</option>
                                    			</c:if>
                                    		</c:if>
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>分类名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="classname" size="50" value="${cate1.CATE_NAME }" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>