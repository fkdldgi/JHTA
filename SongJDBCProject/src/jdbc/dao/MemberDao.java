package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.db.JDBCUtil;
import jdbc.dto.MemberDto;

public class MemberDao {
	MemberDto dto=new MemberDto();
	public int signUp(MemberDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn(); //DB접속
			String sql="insert into member values(?,?,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,dto.getMem_email());
			pstmt.setString(2,dto.getMem_pw());
			pstmt.setString(3,dto.getMem_name());
			pstmt.setLong(4,dto.getMem_resnum());
			pstmt.setLong(5,dto.getMem_phone());
			pstmt.setString(6,dto.getMem_addr());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	public MemberDto login(String email,String pw) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from member where mem_email=? and mem_pw=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "로그인성공!");
				String mem_email=rs.getString("mem_email");
				String mem_pw=rs.getString("mem_pw");
				String mem_name=rs.getString("mem_name");
				long mem_resnum=rs.getLong("mem_resnum");
				long mem_phone=rs.getLong("mem_phone");
				String mem_addr=rs.getString("mem_addr");
				Date mem_regdate=rs.getDate("mem_regdate");
				MemberDto dto=new MemberDto(mem_email,mem_pw,mem_name,mem_resnum,mem_phone,mem_addr,mem_regdate);
				return dto;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	public String selectVerti(String mem_name,long mem_resnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select mem_name from member where mem_name=? and mem_resnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_name);
			pstmt.setLong(2, mem_resnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("mem_name");
				return name;
			}else {
				return "";
			}
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			JOptionPane.showMessageDialog(null, "실명인증에 실패하였습니다.");
			return "";
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
		
		
	}
	public void update() {
		
	}
	public void delete() {
		
	}
}
