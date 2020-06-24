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
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("isLogin");
		PrintWriter out = response.getWriter();
		out.write("<script>");
		out.write("var a = confirm('真的要退出么');");
		out.write("if(a){");
		out.write("location.href='index.jsp';}");
		out.write("else{");
		out.write("alert('彩蛋！这里点击取消后个人信息也没了，解决不了'); ");
		out.write("location.href='index.jsp';}");
		out.write("</script>");
	}
}
