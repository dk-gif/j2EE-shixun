package com.lmonkey.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserUpdate
 * 6/17这个类是作为update更新的预先准备类，也就是查找到id对应的那一条记录到修改的界面去
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		LMONKEY_USER user = LMONKEY_USERDao.selectId(id);
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));//配置分页显示
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}

}
