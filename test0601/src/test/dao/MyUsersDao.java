package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.JDBCUtil;
import test.vo.MyUsersVo;

public class MyUsersDao {
	public ArrayList<MyUsersVo> select(String regdate){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		System.out.println(regdate+"zz");
		try {
			con=JDBCUtil.getConn();
			String sql="select * from myusers where to_char(regdate)=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, regdate);
			rs=pstmt.executeQuery();
			ArrayList<MyUsersVo> list=new ArrayList<MyUsersVo>();
			if(rs.next()) {
				do {
					String id=rs.getString("id");
					String pwd=rs.getString("pwd");
					String email=rs.getString("email");
					Date RegDate=rs.getDate("regdate");
					MyUsersVo vo=new MyUsersVo(id,pwd,email,RegDate);
					list.add(vo);
				}while(rs.next());
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
