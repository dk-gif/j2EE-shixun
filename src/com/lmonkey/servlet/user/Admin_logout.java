package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin_logout
 */
@WebServlet("/manage/admin_logout")
public class Admin_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("isLogin");
		session.removeAttribute("isAdminLogin");
		PrintWriter out = response.getWriter();
		out.write("<script>");
		out.write("alert('尊敬的管理员退出了');");
		out.write("location.href='/Shixun/reg.jsp';");
		out.write("</script>");
	}
}
