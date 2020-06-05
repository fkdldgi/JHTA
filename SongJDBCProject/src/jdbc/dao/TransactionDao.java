package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jdbc.db.JDBCUtil;
import jdbc.dto.TransactionDto;

public class TransactionDao {
	long tr_afmoney1;
	long tr_afmoney2;
	public void transaction(long wdac_num,long deac_num,long tr_money) { //wdac_num=출금될계좌,deac_num=입금될계좌
		Connection con=null;
		PreparedStatement pstmt1=null; //출금될 계좌의 잔액=잔액-거래금액
		PreparedStatement pstmt2=null; //입금될 계좌의 잔액=잔액+거래금액
		PreparedStatement pstmt3=null; //출금된 계좌의 잔액 가져오기
		PreparedStatement pstmt4=null; //입금된 계좌의 잔액 가져오기
		PreparedStatement pstmt5=null; //거래테이블에 출금된 계좌의 거래내역추가
		PreparedStatement pstmt6=null; //거래테이블에 입금된 계좌의 거래내역추가
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getConn();
			con.setAutoCommit(false);
			String sql1="update account set ac_money=ac_money-? where ac_num=?";
			String sql2="update account set ac_money=ac_money+? where ac_num=?";
			String sql3="select ac_money from account where ac_num=?";
			String sql4="select ac_money from account where ac_num=?";
			String sql5="insert into transaction values(transaction_SEQ.nextval,?,?,sysdate,?,?,'출금')";
			String sql6="insert into transaction values(transaction_SEQ.nextval,?,?,sysdate,?,?,'입금')";
			
			//출금될 계좌의 잔액=잔액-거래금액
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setLong(1, tr_money);
			pstmt1.setLong(2, wdac_num);
			pstmt1.executeUpdate();
			
			//입금될 계좌의 잔액=잔액+거래금액
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setLong(1, tr_money);
			pstmt2.setLong(2, deac_num);
			pstmt2.executeUpdate();
			
			//출금된 계좌의 잔액 가져오기
			pstmt3=con.prepareStatement(sql3);
			pstmt3.setLong(1, wdac_num);
			rs=pstmt3.executeQuery();
			if(rs.next()) {
				tr_afmoney1=rs.getLong("ac_money");
			}
			
			//입금된 계좌의 잔액 가져오기
			pstmt4=con.prepareStatement(sql4);
			pstmt4.setLong(1, deac_num);
			rs=pstmt4.executeQuery();
			if(rs.next()) {
				tr_afmoney2=rs.getLong("ac_money");
			}
			
			//거래테이블에 출금된 계좌의 거래내역추가
			pstmt5=con.prepareStatement(sql5);
			pstmt5.setLong(1, wdac_num);
			pstmt5.setLong(2, deac_num);
			pstmt5.setLong(3, tr_money);
			pstmt5.setLong(4,tr_afmoney1);
			pstmt5.executeUpdate();
			
			//거래테이블에 입금된 계좌의 거래내역추가
			pstmt6=con.prepareStatement(sql6);
			pstmt6.setLong(1, wdac_num);
			pstmt6.setLong(2, deac_num);
			pstmt6.setLong(3, tr_money);
			pstmt6.setLong(4,tr_afmoney2);
			pstmt6.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "거래가 완료되었습니다.");
			con.commit();
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			try {
				JOptionPane.showMessageDialog(null, "거래실패!!!");
				con.rollback();
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt6);
			JDBCUtil.close(pstmt5);
			JDBCUtil.close(pstmt4);
			JDBCUtil.close(pstmt3);
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(con);
		}
	}
	//입금된 계좌의 거래테이블 컬럼들을 가져옴
	public ArrayList<TransactionDto> selectDeposit(long ac_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from transaction where deac_num=? and tr_name='입금' order by tr_num desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, ac_num);
			rs=pstmt.executeQuery();
			ArrayList<TransactionDto> list=new ArrayList<TransactionDto>();
			if(rs.next()) {
				do {
					int tr_num=rs.getInt("tr_num");
					long wdac_num=rs.getLong("wdac_num");
					long deac_num=rs.getLong("deac_num");
					Date tr_date=rs.getDate("tr_date");
					long tr_money=rs.getLong("tr_money");
					long tr_afmoney=rs.getLong("tr_afmoney");
					String tr_name=rs.getString("tr_name");
					TransactionDto tdto=new TransactionDto(tr_num,wdac_num,deac_num,tr_date,tr_money,tr_afmoney,tr_name);
					list.add(tdto);
				}while(rs.next());
				return list;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			JOptionPane.showMessageDialog(null, "sql에러에러에러");
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//출금된 계좌의 거래테이블 컬럼들을 가져옴
	public ArrayList<TransactionDto> selectWithdraw(long ac_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from transaction where wdac_num=? and tr_name='출금' order by tr_num desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, ac_num);
			rs=pstmt.executeQuery();
			ArrayList<TransactionDto> list=new ArrayList<TransactionDto>();
			if(rs.next()) {
				do {
					int tr_num=rs.getInt("tr_num");
					long wdac_num=rs.getLong("wdac_num");
					long deac_num=rs.getLong("deac_num");
					Date tr_date=rs.getDate("tr_date");
					long tr_money=rs.getLong("tr_money");
					long tr_afmoney=rs.getLong("tr_afmoney");
					String tr_name=rs.getString("tr_name");
					TransactionDto tdto=new TransactionDto(tr_num,wdac_num,deac_num,tr_date,tr_money,tr_afmoney,tr_name);
					list.add(tdto);
				}while(rs.next());
				return list;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			JOptionPane.showMessageDialog(null, "sql에러에러에러");
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
