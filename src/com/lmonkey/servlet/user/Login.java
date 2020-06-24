package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class Login
 * 6/20 �����������ǻ�ȡ��reg�ĵ�¼����Ϣ��ƥ�����ݿ�����û��������¼�����¼û�в��õ�¼
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���reg��¼������˺���������
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		//�͵�Dao����ȥ����
		int count = LMONKEY_USERDao.selectByNM(username,password);
		
		//�ɹ�����ʧ���ض�������
		if(count > 0) {//ֻҪcount������ʹ���ɹ�
			HttpSession session = request.getSession();
			LMONKEY_USER user = LMONKEY_USERDao.selectAdmin(username,password);
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");//���λ
			if(user.getUSER_ID().equals("root")) {//����˺���root�Ļ�����ת������Աҳ�棬���ǵĻ�ת����ͨ�û�ҳ��
				session.setAttribute("isAdminLogin", "1");//root���λ
				response.sendRedirect("/Shixun/manage/admin_index.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
			}else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('�û���¼ʧ��');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
		}
	}

}
