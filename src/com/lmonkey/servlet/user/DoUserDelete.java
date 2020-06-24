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
 * 6/18日这个类作用是指定某一个用户删除他，包括批量删除这些操作
 */
@WebServlet("/manage/admin_douserdelete")
public class DoUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				//从admin_use获得要删除的信息字段
				String id = request.getParameter("id");
				
				//调用userDao中的删除方法
				int count = LMONKEY_USERDao.del(id);
				
				//成功或是失败重定向到哪里
				if(count > 0) {//只要count大于零就代表成功删除重发送到查询页
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
				}else{//不成功就提示用户，添加失败并直接跳转
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('用户添加失败');");
					out.write("location.href='/manage/admin_douserselect?cp="+request.getParameter("cpage")+"'");
					out.write("</script>");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 批量删除的方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//从admin_use获得要删除的信息字段
		String ids[] = request.getParameterValues("id[]");//request.getParameterValues获得多个值
		
		//调用userDao中的删除方法
		for(int i = 0; i<ids.length;i++) {
			LMONKEY_USERDao.del(ids[i]);
		}
		response.sendRedirect("/Shixun/manage/admin_douserselect");
	}

}
