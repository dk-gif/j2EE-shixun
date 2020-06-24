package com.lmonkey.Ordinary.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class ToOrdinaryUpadate
 */
@WebServlet("/ToOrdinaryUpadate")
public class ToOrdinaryUpadate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		LMONKEY_USER user = LMONKEY_USERDao.selectId(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("usermodify.jsp").forward(request, response);
	}

}
