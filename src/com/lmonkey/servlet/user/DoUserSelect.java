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
 * 6/17 这个类是用来查询用户记录的
 * 并且做了分页的处理还有指定id的模糊查询
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage = 1;//当前页
		int count = 5;//每页的条数
		//获取到用户想要跳转的页面
		String cp = request.getParameter("cp");
		//接受用户搜索的关键字
		String keywords = request.getParameter("keywords");
		if(cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = LMONKEY_USERDao.totalPage(count,keywords);
		ArrayList<LMONKEY_USER> list = LMONKEY_USERDao.selectAll(cpage,count,keywords);
		//放到请求的对象域里
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);//总记录数
		request.setAttribute("tpage", arr[1]);//总页数 
		request.setAttribute("cpage", cpage);//当前是第几页
		if(keywords != null) {
			request.setAttribute("searchParams", "&keywords="+keywords);
		}
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
	}
}
