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
 * Servlet implementation class DoCateSelect
 * 6/21 这个类的作用是对分类表的查询
 */
@WebServlet("/manage/admin_docateselect")
public class DoCateSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LMONKEY_CATEGORY> catelist = LMONKEY_CATEDao.selectAll();
		request.setAttribute("catelist", catelist);//所有得到查询完事的列表设置给catelist
		request.getRequestDispatcher("admin_cate.jsp").forward(request, response);//转发过去
	}
}
