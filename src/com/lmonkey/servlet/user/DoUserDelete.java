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
 * Servlet implementation class DoUserDelete
 * 6/18�������������ָ��ĳһ���û�ɾ��������������ɾ����Щ����
 */
@WebServlet("/manage/admin_douserdelete")
public class DoUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				//��admin_use���Ҫɾ������Ϣ�ֶ�
				String id = request.getParameter("id");
				
				//����userDao�е�ɾ������
				int count = LMONKEY_USERDao.del(id);
				
				//�ɹ�����ʧ���ض�������
				if(count > 0) {//ֻҪcount������ʹ���ɹ�ɾ���ط��͵���ѯҳ
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
				}else{//���ɹ�����ʾ�û������ʧ�ܲ�ֱ����ת
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('�û����ʧ��');");
					out.write("location.href='/manage/admin_douserselect?cp="+request.getParameter("cpage")+"'");
					out.write("</script>");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * ����ɾ���ķ���
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��admin_use���Ҫɾ������Ϣ�ֶ�
		String ids[] = request.getParameterValues("id[]");//request.getParameterValues��ö��ֵ
		
		//����userDao�е�ɾ������
		for(int i = 0; i<ids.length;i++) {
			LMONKEY_USERDao.del(ids[i]);
		}
		response.sendRedirect("/Shixun/manage/admin_douserselect");
	}

}
