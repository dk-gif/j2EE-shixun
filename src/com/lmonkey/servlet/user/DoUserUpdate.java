package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserUpdate
 * 6/18 这个类是admin_usermodify前端页面修改好后，提交处理servlet类
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//设置字符集
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				//从admin_usermodify获得所有添加的信息字段
				String username = request.getParameter("userName");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String sex = request.getParameter("sex");
				String birthday = request.getParameter("birthday");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String address = request.getParameter("address");
				
				//把获取来的数据添加数据库中，先得到用户的实体在添加
				LMONKEY_USER user = new LMONKEY_USER(username,name,password,
						sex,birthday,email,mobile,address);
				//加入数据库
				int count = LMONKEY_USERDao.update(user);
				//成功或是失败重定向到哪里
				if(count > 0) {//只要count大于零就代表有值插入进来
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
					//重定向到用户管理页面。也就是显示全部记录的页，加上cpage是直接在哪里改的页，就回到那个页
				}else{
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('用户修改失败');");
					out.write("location.href='/Shixun/manage/admin_touserupdate?id="+username+"'");
					out.write("</script>");
		}
	}
}

