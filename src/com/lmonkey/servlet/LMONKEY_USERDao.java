package com.lmonkey.servlet;


import java.util.ArrayList;
import java.sql.*;
import com.lmonkey.dao.BaseDao;
import com.lmonkey.entity.LMONKEY_USER;

/**
 * 6/17 ����һ���ۺϵ���ר������������е�ҵ���߼�����(���е�һ�𣬷������)
 * ������servlet�����õ������ݿ����ɾ�Ĳ鶼������ȥѰ�����Ӧ�ķ���**/
public class LMONKEY_USERDao {
	/**�������ݵ����ݿ���**/
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
	/**��ȡ��ҳ�����ܼ�¼����ҳ�ķ���,����һ���û�ģ����ѯ��ķ�ҳ��ʾЧ��**/
	public static int[] totalPage(int count,String keywords) {
		int arr[] = {0,1};
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "";
			if(keywords!=null) {
				sql = "select count(*) from lmonkey_user where USER_NAME like ?";//��һ��ģ����ѯ���ж�������¼
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keywords+"%");		
			}else {
				sql = "select count(*) from lmonkey_user";//��һ���ж�������¼
				ps = conn.prepareStatement(sql);
			}
			
			
			rs = ps.executeQuery();
			while(rs.next()) { //ÿһ������ѹ���ջ��
				arr[0] = rs.getInt(1);//�ܼ�¼��
				if(arr[0]%count==0) { //�������ľͷֵ�һ��ҳ��������˵ķֵ���һҳ��
					arr[1] = arr[0]/count;//��ҳ��
				}else {
					arr[1] = arr[0]/count+1;//��ҳ��
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
	/**��ѯ���е��û���¼**/
	public static ArrayList<LMONKEY_USER> selectAll(int cpage,int count,String keywords){
		  ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
		  //���������
		  ResultSet re = null;
		  //��ȡ���Ӷ���
		  Connection conn = BaseDao.getconn();  
		  PreparedStatement ps = null; 
		  try {
			  String sql="";
			  //�ж��û��Ƿ�ʹ���˹ؼ�������,���ʹ������ô��ִ�йؼ���ģ����ѯ��䣬�����ִ��ȫ����ѯ���
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
		  }finally { //�ر���Դ
		   BaseDao.closeall(re,ps,conn);
		  }
		  return list;
		 }
	/**Ϊ������׼��������idȥ��ѯĳһ���û���ȫ����Ϣ**/
	public static LMONKEY_USER selectId(String id){
		  LMONKEY_USER u = null;
		  //���������
		  ResultSet re = null;
		  //��ȡ���Ӷ���
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
		  }finally { //�ر���Դ
		   BaseDao.closeall(re,ps,conn);
		  }
		  return u;
		 }
	/**�����û��ķ���**/
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
	/**ɾ��һ���û��ķ���**/
	public static int del(String id) {
		String sql = "delete from lmonkey_user where USER_ID=?";
		 Object[] params = {id};  
		return BaseDao.exectuIUD(sql, params);
	}
	/**��ӦUSENAMECHECK����࣬������ݿ����Ƿ�����˺���ͬ**/
	public static int selectByName(String id) {
		//�������ݿ�
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from lmonkey_user where USER_ID=?";//��һ��
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);		
				rs = ps.executeQuery();
				
			while(rs.next()) { //ÿһ������ѹ���ջ��
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
	/**ƥ�����ݿ����Ƿ�������û��������Ӧ������**/
	public static int selectByNM(String username, String password) {
		//�������ݿ�
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count = 0;
		try {
		String sql = "select count(*) from lmonkey_user where USER_ID=? and USER_PASSWORD=?";//��һ��
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);		
		rs = ps.executeQuery();
						
		while(rs.next()) { //ÿһ������ѹ���ջ��
			count = rs.getInt(1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
			return count;
		}
	/**ͨ���õ����˻������������鿴������Ϣ**/
	public static LMONKEY_USER selectAdmin(String username, String password) {
		 LMONKEY_USER u = null;
		  //���������
		  ResultSet re = null;
		  //��ȡ���Ӷ���
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
		  }finally { //�ر���Դ
		   BaseDao.closeall(re,ps,conn);
		  }
		  return u;
	}
	
}
