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
 * ��������������AJAX ��֤ǰ���û��˺�Ψһ��
 */
@WebServlet("/userNamecheck")
public class UserNamecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");//�õ�funciton.js��AJAX������name
		int count = LMONKEY_USERDao.selectByName(name);//��Dao�ۺϹ������ﴫ
		
		PrintWriter out = response.getWriter();
		if(count >0 ) {//������ݿ�������ͬ���ֵ��˺ţ���ô�������
			out.print("false");
		}else {
			out.print("true");
		}
		out.close();//���ر������
	}
}
