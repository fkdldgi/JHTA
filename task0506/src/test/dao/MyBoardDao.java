package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.JDBCUtil;
import test.vo.MyBoardVo;

public class MyBoardDao {
	//검색한 게시글의 갯수
	public int searchCnt(int chkbox,String search) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="";
			switch(chkbox) {
			case 1: sql="select NVL(count(num),0) cnt from myboard where writer like '%' || ? || '%'";
					break;
			case 2:	sql="select NVL(count(num),0) cnt from myboard where title like '%' || ? || '%'";
					break;
			case 3: sql="select NVL(count(num),0) cnt from myboard where content like '%' || ? || '%'";
					break;
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}else {
				return 0;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//작성자 검색
	public ArrayList<MyBoardVo> search(int startRow,int endRow,int chkbox,String search){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="";
			switch(chkbox) {
			case 1: sql="select * from" + 
					"(" + 
					"    select aa.*,rownum rnum from" + 
					"    (\r\n" + 
					"        select * from myboard where writer like '%' || ? || '%' order by num desc" + 
					"    )aa" + 
					")" + 
					"where rnum>=? and rnum<=?";
					break;
			case 2:	sql="select * from" + 
					"(" + 
					"    select aa.*,rownum rnum from" + 
					"    (" + 
					"        select * from myboard where title like '%' || ? || '%' order by num desc" + 
					"    )aa" + 
					")" + 
					"where rnum>=? and rnum<=?";
					break;
			case 3: sql="select * from" + 
					"(" + 
					"    select aa.*,rownum rnum from" + 
					"    (" + 
					"        select * from myboard where content like '%' || ? || '%' order by num desc" + 
					"    )aa" + 
					")" + 
					"where rnum>=? and rnum<=?";
					break;
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs=pstmt.executeQuery();
			ArrayList<MyBoardVo> list=new ArrayList<MyBoardVo>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String writer=rs.getString("writer");
				String pwd=rs.getString("pwd");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date regdate=rs.getDate("regdate");
				list.add(new MyBoardVo(num,writer,pwd,title,content,regdate));
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//글삭제
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="delete from myboard where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	//상세보기
	public MyBoardVo detail(int num){
		String sql="select * from myboard where num=?"; 
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String writer=rs.getString("writer");
				String pwd=rs.getString("pwd");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date regdate=rs.getDate("regdate");
				MyBoardVo vo=new MyBoardVo(num,writer,pwd,title,content,regdate);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//데이터 삽입
	public int insert(MyBoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into myboard values(myboard_Seq.nextval,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
	//전체글의 갯수 리턴
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(num),0) cnt from myboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}else {
				return 0;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	public ArrayList<MyBoardVo> list(int startRow,int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from" + 
					"(" + 
					"    select aa.*,rownum rnum from" + 
					"    (" + 
					"        select * from myboard order by num desc" + 
					"    )aa" + 
					")" + 
					"where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<MyBoardVo> list=new ArrayList<MyBoardVo>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String writer=rs.getString("writer");
				String pwd=rs.getString("pwd");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date regdate=rs.getDate("regdate");
				list.add(new MyBoardVo(num,writer,pwd,title,content,regdate));
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
