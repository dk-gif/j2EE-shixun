package com.lmonkey.servlet.user;

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
 * Servlet implementation class DoUserUpdate
 * 6/18 �������admin_usermodifyǰ��ҳ���޸ĺú��ύ����servlet��
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//�����ַ���
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				//��admin_usermodify���������ӵ���Ϣ�ֶ�
				String username = request.getParameter("userName");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String sex = request.getParameter("sex");
				String birthday = request.getParameter("birthday");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String address = request.getParameter("address");
				
				//�ѻ�ȡ��������������ݿ��У��ȵõ��û���ʵ�������
				LMONKEY_USER user = new LMONKEY_USER(username,name,password,
						sex,birthday,email,mobile,address);
				//�������ݿ�
				int count = LMONKEY_USERDao.update(user);
				//�ɹ�����ʧ���ض�������
				if(count > 0) {//ֻҪcount������ʹ�����ֵ�������
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
					//�ض����û�����ҳ�档Ҳ������ʾȫ����¼��ҳ������cpage��ֱ��������ĵ�ҳ���ͻص��Ǹ�ҳ
				}else{
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('�û��޸�ʧ��');");
					out.write("location.href='/Shixun/manage/admin_touserupdate?id="+username+"'");
					out.write("</script>");
		}
	}
}

