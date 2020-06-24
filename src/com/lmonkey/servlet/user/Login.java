package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class Login
 * 6/20 这个类的作用是获取到reg的登录的信息，匹配数据库中有没有这条记录有则登录没有不让登录
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得reg登录界面的账号名和密码
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		//送到Dao集中去操作
		int count = LMONKEY_USERDao.selectByNM(username,password);
		
		//成功或是失败重定向到哪里
		if(count > 0) {//只要count大于零就代表成功
			HttpSession session = request.getSession();
			LMONKEY_USER user = LMONKEY_USERDao.selectAdmin(username,password);
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");//标记位
			if(user.getUSER_ID().equals("root")) {//如果账号是root的话就跳转到管理员页面，不是的话转到普通用户页面
				session.setAttribute("isAdminLogin", "1");//root标记位
				response.sendRedirect("/Shixun/manage/admin_index.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
			}else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户登录失败');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
		}
	}

}
