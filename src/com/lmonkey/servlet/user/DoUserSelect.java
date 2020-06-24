package com.lmonkey.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.servlet.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserSelect
 * 6/17 �������������ѯ�û���¼��
 * �������˷�ҳ�Ĵ�����ָ��id��ģ����ѯ
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage = 1;//��ǰҳ
		int count = 5;//ÿҳ������
		//��ȡ���û���Ҫ��ת��ҳ��
		String cp = request.getParameter("cp");
		//�����û������Ĺؼ���
		String keywords = request.getParameter("keywords");
		if(cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = LMONKEY_USERDao.totalPage(count,keywords);
		ArrayList<LMONKEY_USER> list = LMONKEY_USERDao.selectAll(cpage,count,keywords);
		//�ŵ�����Ķ�������
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);//�ܼ�¼��
		request.setAttribute("tpage", arr[1]);//��ҳ�� 
		request.setAttribute("cpage", cpage);//��ǰ�ǵڼ�ҳ
		if(keywords != null) {
			request.setAttribute("searchParams", "&keywords="+keywords);
		}
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
	}
}
