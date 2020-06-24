package com.lmonkey.dao;
/**6/17����һ�����Ӻ�������ݵ��࣬���������ó������Է�����ò��ط�����д**/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	 public static Connection getconn() {  //��̬�����ӵ����ݿ�
	  Connection conn = null;
	  String url = "jdbc:mysql://127.0.0.1:3306/lmonkeyshop?serverTimezone=UTC&useSSL=false";
	  String user = "root"; //�û�
	  String passwd = "1111"; //����
	  
	  try{ //�mysql������
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
	 public static int exectuIUD(String sql,Object[] params) { //��Ų����������䣬�Ž����ݿ���
	  int count = 0;
	  
	  Connection conn = BaseDao.getconn(); //���Ӷ���
	  //׼��sql���
	  PreparedStatement ps = null; //Ԥ�������
	  
	  //insert into user(''''''''','') value(?,?,?)�������
	  try {
	   ps = conn.prepareStatement(sql);
	  
	   for(int i = 0; i<params.length; i++) {
	    ps.setObject(i+1,params[i]);
	  }
	   count = ps.executeUpdate();
	  }catch(SQLException e) {
	   e.printStackTrace();
	  }finally { //������ô����Ҫѡ��ر����ݿ�
	   BaseDao.closeall(null, ps, conn);
	  }
	  return count;
	 }
	 public static void closeall(ResultSet re, PreparedStatement ps, Connection conn) {
	  //ResultSet re ���������  PreparedStatement ps Ԥ�������  Connection conn ���Ӷ���
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
