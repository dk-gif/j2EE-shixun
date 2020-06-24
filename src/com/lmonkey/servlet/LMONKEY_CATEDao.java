package com.lmonkey.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.BaseDao;
import com.lmonkey.entity.LMONKEY_CATEGORY;

/** 存放所有的对分类表增删改查等功能,方法集合类 **/
public class LMONKEY_CATEDao {
	/** 查询所有的用户记录**/
	public static ArrayList<LMONKEY_CATEGORY> selectAll() {
		ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
		// 声明结果集
		ResultSet re = null;
		// 获取连接对象
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
		} finally { // 关闭资源
			BaseDao.closeall(re, ps, conn);
		}
		return list;
	}
	/**根据id查询到一个用户的信息**/
	public static LMONKEY_CATEGORY selectId(int id) {
		 LMONKEY_CATEGORY cate = null;
		  //声明结果集
		  ResultSet re = null;
		  //获取连接对象
		  Connection conn = BaseDao.getconn();  
		  PreparedStatement ps = null; 
		  try {
			  String sql="select * from lmonkey_category where CATE_ID=?";
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1, id);
		
		   re = ps.executeQuery();
		   while(re.next()) {
			   cate = new LMONKEY_CATEGORY( //放到bean中
		      re.getInt("CATE_ID"),
		      re.getString("CATE_NAME"),
		      re.getInt("CATE_PARTENR_ID")
		      );
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally { //关闭资源
		   BaseDao.closeall(re,ps,conn);
		  }
		  return cate;
	}
	/**插入一个分类**/
		public static int insert(LMONKEY_CATEGORY cate) {
			   String sql = "insert into LMONKEY_CATEGORY "
			   		+ "values(null,?,?)";		   
			   Object[] params = {
			     cate.getCATE_NAME(),
			     cate.getCATE_PARTENR_ID()
			   };  
			   return BaseDao.exectuIUD(sql, params);		
	}
	/**更新一个用户的信息**/
	public static int update(LMONKEY_CATEGORY cate) {
		   String sql = "update LMONKEY_CATEGORY set CATE_NAME=?,CATE_PARTENR_ID=? where CATE_ID=?";		   
		   Object[] params = {  
				     cate.getCATE_NAME(),
				     cate.getCATE_PARTENR_ID(),
				     cate.getCATE_ID()
				   };  
		   return BaseDao.exectuIUD(sql, params);
	}
	/**删除一个用户的方法**/
	public static int delete(int id) {
		String sql = "delete from LMONKEY_CATEGORY where CATE_ID=?";
		 Object[] params = {id};  
		return BaseDao.exectuIUD(sql, params);
	}
}
