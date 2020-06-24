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
 * 6/19�����������Ƕ���֤�����ȷ�Խ����жϵ���
 */
@WebServlet("/checkusernum")
public class Checkusernum extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num"); //�õ�function���洫������num
		
		HttpSession session = request.getSession();//Ҫ�õ�������Codeservlet�е����ɵ���֤��
		String sysCode = (String)session.getAttribute("code");//����һ��,���������ɵ���֤��
		
		PrintWriter out = response.getWriter();
		if(sysCode.equals(num)) {//���ƥ��ɹ��򷵻���ȷ
			out.print("true");
		}else {
			out.print("false");
		}
		out.close();//���ر������
	}
}
