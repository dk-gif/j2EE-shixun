package com.lmonkey.dao;
/**6/17这是一个连接后端与数据的类，把他单独拿出来可以方便调用不必反复重写**/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	 public static Connection getconn() {  //静态的连接到数据库
	  Connection conn = null;
	  String url = "jdbc:mysql://127.0.0.1:3306/lmonkeyshop?serverTimezone=UTC&useSSL=false";
	  String user = "root"; //用户
	  String passwd = "1111"; //密码
	  
	  try{ //搭建mysql的驱动
	   Class.forName("com.mysql.cj.jdbc.Driver");
	  }catch(ClassNotFoundException e){
	   e.printStackTrace();
	  }
	  
	  try {
	   conn = DriverManager.getConnection(url, user, passwd);
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	  return conn;
	 }
	 public static int exectuIUD(String sql,Object[] params) { //存放插入进来的语句，放进数据库中
	  int count = 0;
	  
	  Connection conn = BaseDao.getconn(); //连接对象
	  //准备sql语句
	  PreparedStatement ps = null; //预处理对象
	  
	  //insert into user(''''''''','') value(?,?,?)插入语句
	  try {
	   ps = conn.prepareStatement(sql);
	  
	   for(int i = 0; i<params.length; i++) {
	    ps.setObject(i+1,params[i]);
	  }
	   count = ps.executeUpdate();
	  }catch(SQLException e) {
	   e.printStackTrace();
	  }finally { //不管怎么样都要选择关闭数据库
	   BaseDao.closeall(null, ps, conn);
	  }
	  return count;
	 }
	 public static void closeall(ResultSet re, PreparedStatement ps, Connection conn) {
	  //ResultSet re 结果集对象  PreparedStatement ps 预处理对象  Connection conn 连接对象
	   try {
	     if(re!=null)
	      re.close();
	     if(ps!=null)
	      ps.close();
	     if(conn!=null)
	      conn.close();
	   } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	 }  
	}
}
