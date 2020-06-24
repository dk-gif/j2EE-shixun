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
 * Servlet implementation class Checkusernum
 * 6/19这个类得作用是对验证码得正确性进行判断得类
 */
@WebServlet("/checkusernum")
public class Checkusernum extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num"); //得到function里面传过来的num
		
		HttpSession session = request.getSession();//要得到工具类Codeservlet中的生成的验证码
		String sysCode = (String)session.getAttribute("code");//保存一下,工具类生成的验证码
		
		PrintWriter out = response.getWriter();
		if(sysCode.equals(num)) {//如果匹配成功则返回正确
			out.print("true");
		}else {
			out.print("false");
		}
		out.close();//最后关闭这个流
	}
}
