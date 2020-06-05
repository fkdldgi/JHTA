package test01_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import test.db.JDBCUtil;

/*
 * 배치프로그램
 * - 많은 sql구문을 한꺼번에 실행(DML구문에 적용)
 * - 대용량 업데이트시 속도향상을 위해 BATCH를 사용한다.
 *  
 */
class MyJDBC01{
	public MyJDBC01() {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			con.setAutoCommit(false);
			System.out.println("DB접속성공!");
			String sql="insert into batchtest values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			Random rnd=new Random();
			for(int i=1;i<=100000;i++) {
				long uid=System.currentTimeMillis(); //1970년1월1일0시0분0초이후에 발생된 이후의 밀리초를 가져옴(중복되지않는값을 가져올때도 쓰임)
				String name="홍길동_"+ uid; //이름도 중복되지 않는값을 넣기 위함
				int age=rnd.nextInt(80)+20;
				pstmt.setLong(1, uid);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.addBatch(); //배치에 담기
				if(i%10000==0) {
					pstmt.executeBatch(); //배치에 담긴 sql구문을 한꺼번에 실행하기
					pstmt.clearBatch(); //배치 지우기
					con.commit();
				}
				//pstmt.executeUpdate();
				//con.commit();
			}
			System.out.println("데이터추가성공!!!!!!!!");
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









