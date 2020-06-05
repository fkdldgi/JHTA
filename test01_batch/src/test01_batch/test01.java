package test01_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import test.db.JDBCUtil;

/*
 * ��ġ���α׷�
 * - ���� sql������ �Ѳ����� ����(DML������ ����)
 * - ��뷮 ������Ʈ�� �ӵ������ ���� BATCH�� ����Ѵ�.
 *  
 */
class MyJDBC01{
	public MyJDBC01() {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			con.setAutoCommit(false);
			System.out.println("DB���Ӽ���!");
			String sql="insert into batchtest values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			Random rnd=new Random();
			for(int i=1;i<=100000;i++) {
				long uid=System.currentTimeMillis(); //1970��1��1��0��0��0�����Ŀ� �߻��� ������ �и��ʸ� ������(�ߺ������ʴ°��� �����ö��� ����)
				String name="ȫ�浿_"+ uid; //�̸��� �ߺ����� �ʴ°��� �ֱ� ����
				int age=rnd.nextInt(80)+20;
				pstmt.setLong(1, uid);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.addBatch(); //��ġ�� ���
				if(i%10000==0) {
					pstmt.executeBatch(); //��ġ�� ��� sql������ �Ѳ����� �����ϱ�
					pstmt.clearBatch(); //��ġ �����
					con.commit();
				}
				//pstmt.executeUpdate();
				//con.commit();
			}
			System.out.println("�������߰�����!!!!!!!!");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
}
public class test01 {
	public static void main(String[] args) {
		new MyJDBC01();
	}
}









