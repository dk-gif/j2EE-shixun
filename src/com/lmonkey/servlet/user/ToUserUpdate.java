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
 * 6/17���������Ϊupdate���µ�Ԥ��׼���࣬Ҳ���ǲ��ҵ�id��Ӧ����һ����¼���޸ĵĽ���ȥ
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		LMONKEY_USER user = LMONKEY_USERDao.selectId(id);
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));//���÷�ҳ��ʾ
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}

}
