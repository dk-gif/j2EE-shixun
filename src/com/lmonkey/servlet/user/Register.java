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
 * Servlet implementation class Register
 * 6/20 这个类是负责把注册页面reg提交的信息给添加到数据库中，跟DouserAdd差不多
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				//从admin_useradd获得所有添加的信息字段
				String username = request.getParameter("userName");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String sex = request.getParameter("sex");
				String birthday = request.getParameter("birthday");
				String email = request.getParameter("email");
				String modify = request.getParameter("mobile");
				String address = request.getParameter("address");
				
				//把获取来的数据添加数据库中，先得到用户的实体在添加
				LMONKEY_USER u = new LMONKEY_USER(username,name,password,
						sex,birthday,email,modify,address);
				//加入数据库
				int count = LMONKEY_USERDao.insert(u);
				
				//成功或是失败重定向到哪里
				if(count > 0) {//只要count大于零就代表有值插入进来
					response.sendRedirect("reg.jsp");
				}else{
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('注册失败了哟');");
					out.write("location.href='reg.jsp';");
					out.write("</script>");
		}
	}
}
