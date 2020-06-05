package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.JDBCUtil;
import test.vo.BoardVo;

public class BoardDao {
	//가장 큰 글번호 구하는 메소드
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(max(num),0) maxnum from guestboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxnum");
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
	public int insert(BoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=JDBCUtil.getConn();
			int boardNum=getMaxNum()+1; //등록할 글 번호 구하기
			int num=vo.getNum();
			int ref=vo.getRef();
			int lev=vo.getLev();
			int step=vo.getStep();
			if(num==0) { //새글인 경우
				ref=boardNum;
			}else { //답글인 경우
				String sql1="update guestboard set step=step+1 where ref=? and step>?";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, ref);
				pstmt1.setInt(2, step);
				pstmt1.executeUpdate();
				
				lev +=1;
				step +=1;
			}
			String sql2="insert into guestboard values(?,?,?,?,?,?,?)";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, boardNum);
			pstmt2.setString(2, vo.getWriter());
			pstmt2.setString(3, vo.getTitle());
			pstmt2.setString(4, vo.getContent());
			pstmt2.setInt(5, ref);
			pstmt2.setInt(6, lev);
			pstmt2.setInt(7, step);
			pstmt2.executeUpdate();
			return 1;
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(con);
		}
	}
	public ArrayList<BoardVo> list(int startRow,int endRow){
		String sql="select * from" + 
				"(" + 
				"    select aa.*,rownum rnum from" + 
				"    (" + 
				"        select * from guestboard order by ref desc,step asc" + 
				"    )aa" + 
				")" + 
				"where rnum>=? and rnum<=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<BoardVo> list=new ArrayList<BoardVo>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				BoardVo vo=new BoardVo(num,writer,title,content,ref,lev,step);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//전체글의 갯수 리턴
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(num),0) cnt from guestboard";
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
	
	public BoardVo detail(int num){
		String sql="select * from guestboard where num=?"; 
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
				String title=rs.getString("title");
				String content=rs.getString("content");
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				BoardVo vo=new BoardVo(num,writer,title,content,ref,lev,step);
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
}


















