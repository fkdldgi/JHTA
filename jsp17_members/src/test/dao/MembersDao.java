package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.JDBCUtil;
import test.vo.MembersVo;

public class MembersDao {
	//회원정보 수정
	public int update(MembersVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update members set name=?,phone=?,addr=? where num=?";
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getAddr());
			pstmt.setInt(4, vo.getNum());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	//회원정보 검색
	public MembersVo select(int n) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from members where num=?";
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n);
			rs=pstmt.executeQuery();
			MembersVo vo=new MembersVo();
			if(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				vo=new MembersVo(num,name,phone,addr,regdate);
			}
			return vo;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	
	
	//회원정보 삭제
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from members where num=?";
		int n=0;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	
	//전체 회원정보를 ArrayList에 담아서 리턴
	public ArrayList<MembersVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from members order by num";
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<MembersVo> list=new ArrayList<MembersVo>();
			if(rs.next()) {
				do {
					int num=rs.getInt("num");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					String addr=rs.getString("addr");
					Date regdate=rs.getDate("regdate");
					list.add(new MembersVo(num,name,phone,addr,regdate));
				}while(rs.next());
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	public int insert(MembersVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into members values(?,?,?,?,sysdate)";
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddr());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
		
	}
}
