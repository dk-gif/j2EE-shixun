package com.lmonkey.servlet;


import java.util.ArrayList;
import java.sql.*;
import com.lmonkey.dao.BaseDao;
import com.lmonkey.entity.LMONKEY_USER;

/**
 * 6/17 这是一个综合的类专门用来存放所有的业务逻辑代码(集中到一起，方便管理)
 * 其他的servlet凡是用到对数据库的增删改查都到这里去寻找相对应的方法**/
public class LMONKEY_USERDao {
	/**插入数据到数据库中**/
	public static int insert(LMONKEY_USER u) {
		   String sql = "insert into lmonkey_user "
		   		+ "values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?)";		   
		   Object[] params = {
		     u.getUSER_ID(),
		     u.getUSER_NAME(),
		     u.getUSER_PASSWORD(),
		     u.getUSER_SEX(),
		     u.getUSER_BIRTHDAY(),
		     u.getUSER_EMAIL(),
		     u.getUSER_MOBILE(),
		     u.getUSER_ADDRESS()
		   };  
		   return BaseDao.exectuIUD(sql, params);
		  }
	/**获取总页数和总记录，分页的方法,新增一个用户模糊查询后的分页显示效果**/
	public static int[] totalPage(int count,String keywords) {
		int arr[] = {0,1};
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "";
			if(keywords!=null) {
				sql = "select count(*) from lmonkey_user where USER_NAME like ?";//查一下模糊查询后有多少条记录
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keywords+"%");		
			}else {
				sql = "select count(*) from lmonkey_user";//查一下有多少条记录
				ps = conn.prepareStatement(sql);
			}
			
			
			rs = ps.executeQuery();
			while(rs.next()) { //每一条都给压入的栈中
				arr[0] = rs.getInt(1);//总记录数
				if(arr[0]%count==0) { //能整除的就分到一个页里，整除不了的分到下一页里
					arr[1] = arr[0]/count;//分页数
				}else {
					arr[1] = arr[0]/count+1;//分页数
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return arr;
	}
	/**查询所有的用户记录**/
	public static ArrayList<LMONKEY_USER> selectAll(int cpage,int count,String keywords){
		  ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
		  //声明结果集
		  ResultSet re = null;
		  //获取连接对象
		  Connection conn = BaseDao.getconn();  
		  PreparedStatement ps = null; 
		  try {
			  String sql="";
			  //判断用户是否使用了关键字搜索,如果使用了那么就执行关键字模糊查询语句，否则就执行全部查询语句
			  if(keywords!=null) {
				  sql="select * from  lmonkey_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?";
				  ps = conn.prepareStatement(sql);
				  ps.setString(1, "%"+keywords+"%");
				  ps.setInt(2, (cpage-1)*count);
				  ps.setInt(3,count);
			  }else {
				  sql="select * from  lmonkey_user order by USER_BIRTHDAY desc limit ?,?";
				  ps = conn.prepareStatement(sql);
				  ps.setInt(1, (cpage-1)*count);
				  ps.setInt(2,count);
			  }
		   
		  
		   re = ps.executeQuery();
		   while(re.next()) {
			   LMONKEY_USER u = new LMONKEY_USER(
		      re.getString("USER_ID"),
		      re.getString("USER_NAME"),
		      re.getString("USER_PASSWORD"),
		      re.getString("USER_SEX"),
		      re.getString("USER_BIRTHDAY"),
		      re.getString("USER_EMAIL"),
		      re.getString("USER_MOBILE"),
		      re.getString("USER_ADDRESS")
		      );
		    
		    list.add(u);
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally { //关闭资源
		   BaseDao.closeall(re,ps,conn);
		  }
		  return list;
		 }
	/**为更新做准备，根据id去查询某一个用户的全部信息**/
	public static LMONKEY_USER selectId(String id){
		  LMONKEY_USER u = null;
		  //声明结果集
		  ResultSet re = null;
		  //获取连接对象
		  Connection conn = BaseDao.getconn();  
		  PreparedStatement ps = null; 
		  try {
			  String sql="select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from lmonkey_user m where USER_ID=?";
			  ps = conn.prepareStatement(sql);
			  ps.setString(1, id);
		
		   re = ps.executeQuery();
		   while(re.next()) {
			   u = new LMONKEY_USER(
		      re.getString("USER_ID"),
		      re.getString("USER_NAME"),
		      re.getString("USER_PASSWORD"),
		      re.getString("USER_SEX"),
		      re.getString("birthday"),
		      re.getString("USER_EMAIL"),
		      re.getString("USER_MOBILE"),
		      re.getString("USER_ADDRESS")
		      );
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally { //关闭资源
		   BaseDao.closeall(re,ps,conn);
		  }
		  return u;
		 }
	/**更新用户的方法**/
	public static int update(LMONKEY_USER u) {
		   String sql = "update lmonkey_user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d'),USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=? where USER_ID=?";		   
		   Object[] params = {  
				     u.getUSER_NAME(),
				     u.getUSER_PASSWORD(),
				     u.getUSER_SEX(),
				     u.getUSER_BIRTHDAY(),
				     u.getUSER_EMAIL(),
				     u.getUSER_MOBILE(),
				     u.getUSER_ADDRESS(),
				     u.getUSER_ID()
				   };  
		   return BaseDao.exectuIUD(sql, params);
	}
	/**删除一个用户的方法**/
	public static int del(String id) {
		String sql = "delete from lmonkey_user where USER_ID=?";
		 Object[] params = {id};  
		return BaseDao.exectuIUD(sql, params);
	}
	/**对应USENAMECHECK这个类，检查数据库中是否存在账号相同**/
	public static int selectByName(String id) {
		//连接数据库
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from lmonkey_user where USER_ID=?";//查一下
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);		
				rs = ps.executeQuery();
				
			while(rs.next()) { //每一条都给压入的栈中
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return count;
	}
	/**匹配数据库中是否有这个用户名和相对应得密码**/
	public static int selectByNM(String username, String password) {
		//连接数据库
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count = 0;
		try {
		String sql = "select count(*) from lmonkey_user where USER_ID=? and USER_PASSWORD=?";//查一下
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);		
		rs = ps.executeQuery();
						
		while(rs.next()) { //每一条都给压入的栈中
			count = rs.getInt(1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
			return count;
		}
	/**通过得到得账户名和密码来查看所有信息**/
	public static LMONKEY_USER selectAdmin(String username, String password) {
		 LMONKEY_USER u = null;
		  //声明结果集
		  ResultSet re = null;
		  //获取连接对象
		  Connection conn = BaseDao.getconn();  
		  PreparedStatement ps = null; 
		  try {
			  String sql="select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from lmonkey_user m where USER_ID=? and USER_PASSWORD=?";
			  ps = conn.prepareStatement(sql);
			  ps.setString(1, username);
			  ps.setString(2, password);
		
		   re = ps.executeQuery();
		   while(re.next()) {
			   u = new LMONKEY_USER(
		      re.getString("USER_ID"),
		      re.getString("USER_NAME"),
		      re.getString("USER_PASSWORD"),
		      re.getString("USER_SEX"),
		      re.getString("birthday"),
		      re.getString("USER_EMAIL"),
		      re.getString("USER_MOBILE"),
		      re.getString("USER_ADDRESS")
		      );
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally { //关闭资源
		   BaseDao.closeall(re,ps,conn);
		  }
		  return u;
	}
	
}
