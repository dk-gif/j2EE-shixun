package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class UserNamecheck
 * 这个类的作用利用AJAX 验证前端用户账号唯一性
 */
@WebServlet("/userNamecheck")
public class UserNamecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");//得到funciton.js的AJAX所传的name
		int count = LMONKEY_USERDao.selectByName(name);//往Dao综合工具类里传
		
		PrintWriter out = response.getWriter();
		if(count >0 ) {//如果数据库里有相同名字得账号，那么就输出假
			out.print("false");
		}else {
			out.print("true");
		}
		out.close();//最后关闭这个流
	}
}
