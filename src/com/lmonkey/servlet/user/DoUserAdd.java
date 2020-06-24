package com.lmonkey.servlet.user;
/**
 * 6/17����û����ҳ���servlet��ǰ��jspҳ��bean�������Ǹ�com.lmonkey.entity**/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��admin_useradd���������ӵ���Ϣ�ֶ�
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String modify = request.getParameter("modify");
		String address = request.getParameter("address");
		
		//�ѻ�ȡ��������������ݿ��У��ȵõ��û���ʵ�������
		LMONKEY_USER u = new LMONKEY_USER(username,name,password,
				sex,birthday,email,modify,address);
		//�������ݿ�
		int count = LMONKEY_USERDao.insert(u);
		
		//�ɹ�����ʧ���ض�������
		if(count > 0) {//ֻҪcount������ʹ�����ֵ�������
			response.sendRedirect("admin_douserselect");
		}else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('�û����ʧ��');");
			out.write("location.href='/Shixun/manage/admin_useradd.jsp';");
			out.write("</script>");
		}
	}

}
