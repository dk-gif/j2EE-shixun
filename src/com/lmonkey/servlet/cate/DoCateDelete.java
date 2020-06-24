package com.lmonkey.servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.servlet.LMONKEY_CATEDao;

/**
 * Servlet implementation class DoCateDelete
 */
@WebServlet("/manage/admin_docatedel")
public class DoCateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		LMONKEY_CATEDao.delete(id);
		response.sendRedirect("admin_docateselect");
	}

}
