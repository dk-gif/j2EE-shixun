package com.lmonkey.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.BaseDao;
import com.lmonkey.entity.LMONKEY_CATEGORY;

/** ������еĶԷ������ɾ�Ĳ�ȹ���,���������� **/
public class LMONKEY_CATEDao {
	/** ��ѯ���е��û���¼**/
	public static ArrayList<LMONKEY_CATEGORY> selectAll() {
		ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
		// ���������
		ResultSet re = null;
		// ��ȡ���Ӷ���
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from  lmonkey_category";
			ps = conn.prepareStatement(sql);
			re = ps.executeQuery();
			while (re.next()) {
				LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY(re.getInt("CATE_ID"), re.getString("CATE_NAME"),
						re.getInt("CATE_PARTENR_ID"));
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // �ر���Դ
			BaseDao.closeall(re, ps, conn);
		}
		return list;
	}
	/**����id��ѯ��һ���û�����Ϣ**/
	public static LMONKEY_CATEGORY selectId(int id) {
		 LMONKEY_CATEGORY cate = null;
		  //���������
		  ResultSet re = null;
		  //��ȡ���Ӷ���
		  Connection conn = BaseDao.getconn();  
		  PreparedStatement ps = null; 
		  try {
			  String sql="select * from lmonkey_category where CATE_ID=?";
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1, id);
		
		   re = ps.executeQuery();
		   while(re.next()) {
			   cate = new LMONKEY_CATEGORY( //�ŵ�bean��
		      re.getInt("CATE_ID"),
		      re.getString("CATE_NAME"),
		      re.getInt("CATE_PARTENR_ID")
		      );
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally { //�ر���Դ
		   BaseDao.closeall(re,ps,conn);
		  }
		  return cate;
	}
	/**����һ������**/
		public static int insert(LMONKEY_CATEGORY cate) {
			   String sql = "insert into LMONKEY_CATEGORY "
			   		+ "values(null,?,?)";		   
			   Object[] params = {
			     cate.getCATE_NAME(),
			     cate.getCATE_PARTENR_ID()
			   };  
			   return BaseDao.exectuIUD(sql, params);		
	}
	/**����һ���û�����Ϣ**/
	public static int update(LMONKEY_CATEGORY cate) {
		   String sql = "update LMONKEY_CATEGORY set CATE_NAME=?,CATE_PARTENR_ID=? where CATE_ID=?";		   
		   Object[] params = {  
				     cate.getCATE_NAME(),
				     cate.getCATE_PARTENR_ID(),
				     cate.getCATE_ID()
				   };  
		   return BaseDao.exectuIUD(sql, params);
	}
	/**ɾ��һ���û��ķ���**/
	public static int delete(int id) {
		String sql = "delete from LMONKEY_CATEGORY where CATE_ID=?";
		 Object[] params = {id};  
		return BaseDao.exectuIUD(sql, params);
	}
}
