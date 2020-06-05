package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import test.db.JDBCUtil;

/*
 * [ �̱������� ]
 * - ��ü�� �ϳ��� �����ؼ� �����ؼ� ����ϴ� ���
 * - ����� ���
 * 	 1. �ڱ��ڽ��� ��ü�� static����� �����Ѵ�.
 * 	 2. ��ü�� �����ϴ� �޼ҵ带 �����Ѵ�.
 * 	 3. �����ڸ� private�� �����.
 */
public class LoginDao {
	private static LoginDao dao=new LoginDao();
	private LoginDao() {} //�����ڸ� private�� �����(�ٸ������� LoginDao dao=new LoginDao(); ó�� ��ü�� �������� ���ϵ����ϱ� ���� ����)
	public static LoginDao getDao() {
		return dao;
	}
	public int isMember(HashMap<String, String> map) {
		String id=map.get("id");
		String pwd=map.get("pwd");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from myusers where id=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) { //���̵�� ��й�ȣ�� �����ϸ�(ȸ���ΰ�� 1����)
				return 1;
			}
			return 2; //ȸ���� �ƴѰ��� 2 ����
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1; //���ܰ� �߻��ϸ� -1����
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
