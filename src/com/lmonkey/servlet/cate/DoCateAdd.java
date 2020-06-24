package com.lmonkey.servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.servlet.LMONKEY_CATEDao;

/**
 * Servlet implementation class DoCateAdd
 * 6/23 这个类是分类的添加get方法查看所有的信息post方法修改信息
 */
@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LMONKEY_CATEGORY> catelist = LMONKEY_CATEDao.selectAll();
		request.setAttribute("catelist", catelist);//所有得到查询完事的列表设置给catelist
		request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);//转发过去
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("classname");
		
		LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY(0,name,fid);
		LMONKEY_CATEDao.insert(cate);
		response.sendRedirect("admin_docateselect");
	}
}
