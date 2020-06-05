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
	public void transaction(long wdac_num,long deac_num,long tr_money) { //wdac_num=��ݵɰ���,deac_num=�Աݵɰ���
		Connection con=null;
		PreparedStatement pstmt1=null; //��ݵ� ������ �ܾ�=�ܾ�-�ŷ��ݾ�
		PreparedStatement pstmt2=null; //�Աݵ� ������ �ܾ�=�ܾ�+�ŷ��ݾ�
		PreparedStatement pstmt3=null; //��ݵ� ������ �ܾ� ��������
		PreparedStatement pstmt4=null; //�Աݵ� ������ �ܾ� ��������
		PreparedStatement pstmt5=null; //�ŷ����̺� ��ݵ� ������ �ŷ������߰�
		PreparedStatement pstmt6=null; //�ŷ����̺� �Աݵ� ������ �ŷ������߰�
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getConn();
			con.setAutoCommit(false);
			String sql1="update account set ac_money=ac_money-? where ac_num=?";
			String sql2="update account set ac_money=ac_money+? where ac_num=?";
			String sql3="select ac_money from account where ac_num=?";
			String sql4="select ac_money from account where ac_num=?";
			String sql5="insert into transaction values(transaction_SEQ.nextval,?,?,sysdate,?,?,'���')";
			String sql6="insert into transaction values(transaction_SEQ.nextval,?,?,sysdate,?,?,'�Ա�')";
			
			//��ݵ� ������ �ܾ�=�ܾ�-�ŷ��ݾ�
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setLong(1, tr_money);
			pstmt1.setLong(2, wdac_num);
			pstmt1.executeUpdate();
			
			//�Աݵ� ������ �ܾ�=�ܾ�+�ŷ��ݾ�
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setLong(1, tr_money);
			pstmt2.setLong(2, deac_num);
			pstmt2.executeUpdate();
			
			//��ݵ� ������ �ܾ� ��������
			pstmt3=con.prepareStatement(sql3);
			pstmt3.setLong(1, wdac_num);
			rs=pstmt3.executeQuery();
			if(rs.next()) {
				tr_afmoney1=rs.getLong("ac_money");
			}
			
			//�Աݵ� ������ �ܾ� ��������
			pstmt4=con.prepareStatement(sql4);
			pstmt4.setLong(1, deac_num);
			rs=pstmt4.executeQuery();
			if(rs.next()) {
				tr_afmoney2=rs.getLong("ac_money");
			}
			
			//�ŷ����̺� ��ݵ� ������ �ŷ������߰�
			pstmt5=con.prepareStatement(sql5);
			pstmt5.setLong(1, wdac_num);
			pstmt5.setLong(2, deac_num);
			pstmt5.setLong(3, tr_money);
			pstmt5.setLong(4,tr_afmoney1);
			pstmt5.executeUpdate();
			
			//�ŷ����̺� �Աݵ� ������ �ŷ������߰�
			pstmt6=con.prepareStatement(sql6);
			pstmt6.setLong(1, wdac_num);
			pstmt6.setLong(2, deac_num);
			pstmt6.setLong(3, tr_money);
			pstmt6.setLong(4,tr_afmoney2);
			pstmt6.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "�ŷ��� �Ϸ�Ǿ����ϴ�.");
			con.commit();
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			try {
				JOptionPane.showMessageDialog(null, "�ŷ�����!!!");
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
	//�Աݵ� ������ �ŷ����̺� �÷����� ������
	public ArrayList<TransactionDto> selectDeposit(long ac_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from transaction where deac_num=? and tr_name='�Ա�' order by tr_num desc";
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
			JOptionPane.showMessageDialog(null, "sql������������");
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//��ݵ� ������ �ŷ����̺� �÷����� ������
	public ArrayList<TransactionDto> selectWithdraw(long ac_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from transaction where wdac_num=? and tr_name='���' order by tr_num desc";
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
			JOptionPane.showMessageDialog(null, "sql������������");
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
