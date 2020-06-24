package com.lmonkey.Ordinary.user;

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
 * Servlet implementation class DoOrdinaryUpdate
 * �����޴� ���⣬�û���¼ʱЯ�����ǵ�ʱ����Ϣ��û�и��Ĺ��ģ���ʹ�õ�session�����
 * ���޸ĺ��ǰ��ҳ��ˢ����Ч(����δ���ĵ���Ϣ)���޷��������취��ֻ�����û��˻ص���½����
 * ����ȥЯ���µ���Ϣȥ��¼
 */
@WebServlet("/DoOrdinaryUpdate")
public class DoOrdinaryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��usermodify���������ӵ���Ϣ�ֶ�
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
		PrintWriter out = response.getWriter();
		if(count > 0) {//ֻҪcount������ʹ�����ֵ�������	
			out.write("<script>");
			out.write("alert('�û��޸ĳɹ��������µ�¼');");
			out.write("location.href='/Shixun/reg.jsp';");
			out.write("</script>");
			//�ض����û�����ҳ��
		}else{
			out.write("<script>");
			out.write("alert('�û��޸�ʧ��');");
			out.write("location.href='/Shixun/user.jsp';");
			out.write("</script>");
		}
	}

}
