package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.db.JDBCUtil;
import jdbc.dto.AccountDto;

public class AccountDao {
	//계좌생성
	public int insertNew(AccountDto adto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into account values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, adto.getAc_num());
			pstmt.setString(2, adto.getMem_email());
			pstmt.setInt(3, adto.getAc_pw());
			pstmt.setLong(4, adto.getAc_money());
			pstmt.setString(5, adto.getAc_bname());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	//계좌 갯수 얻어오기
	public int selectCount(String mem_email) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select count(*) 계좌수 from account where mem_email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_email);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("계좌수");
			}else {
				return -1;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//이메일을 입력받아 모든 계좌테이블값 가져오기
	public ArrayList<AccountDto> selectAll(String mem_email){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<AccountDto> list=new ArrayList<AccountDto>();
		try {
			con=JDBCUtil.getConn();
			String sql="select * from account where mem_email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_email);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				long ac_num=rs.getLong("ac_num");
				int ac_pw=rs.getInt("ac_pw");
				long ac_money=rs.getLong("ac_money");
				String ac_bname=rs.getString("ac_bname");
				AccountDto adto=new AccountDto(ac_num, mem_email, ac_pw, ac_money, ac_bname);
				list.add(adto);
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
