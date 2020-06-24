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
 * Servlet implementation class ToCateUpdate
 * 6/23利用get方法,根据id查询到一个用户信息,在利用post方法修改一个用户的信息
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LMONKEY_CATEGORY cate = LMONKEY_CATEDao.selectId(id);
		ArrayList<LMONKEY_CATEGORY> catelist = LMONKEY_CATEDao.selectAll();
		request.setAttribute("catelist", catelist);//所有得到查询完事的列表设置给catelist
		request.setAttribute("cate1", cate);//所有得到查询完事的列表设置给cate1
		request.getRequestDispatcher("admin_cate_modify.jsp").forward(request, response);//转发过去
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("classname");
		
		LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY(id,name,fid);
		LMONKEY_CATEDao.update(cate);
		response.sendRedirect("admin_docateselect");
	}
}
