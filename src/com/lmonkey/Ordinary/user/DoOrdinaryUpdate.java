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
 * 遭遇巨大 问题，用户登录时携带的是当时的信息（没有更改过的），使用的session保存的
 * 在修改后的前端页面刷新无效(还是未更改的信息)，无法解决这个办法，只能让用户退回到登陆界面
 * 重新去携带新的信息去登录
 */
@WebServlet("/DoOrdinaryUpdate")
public class DoOrdinaryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//从usermodify获得所有添加的信息字段
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		//把获取来的数据添加数据库中，先得到用户的实体在添加
		LMONKEY_USER user = new LMONKEY_USER(username,name,password,
				sex,birthday,email,mobile,address);
		//加入数据库
		int count = LMONKEY_USERDao.update(user);
		//成功或是失败重定向到哪里
		PrintWriter out = response.getWriter();
		if(count > 0) {//只要count大于零就代表有值插入进来	
			out.write("<script>");
			out.write("alert('用户修改成功，请重新登录');");
			out.write("location.href='/Shixun/reg.jsp';");
			out.write("</script>");
			//重定向到用户管理页面
		}else{
			out.write("<script>");
			out.write("alert('用户修改失败');");
			out.write("location.href='/Shixun/user.jsp';");
			out.write("</script>");
		}
	}

}
