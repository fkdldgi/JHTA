package task.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import task.vo.BoardVo;
import test.db.JDBCUtil;

public class BoardDao {
	//제목으로 검색
	public ArrayList<BoardVo> search(String title){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from board where title like ? order by num";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs=pstmt.executeQuery();
			ArrayList<BoardVo> list=new ArrayList<BoardVo>();
			BoardVo vo=new BoardVo();
			if(rs.next()) {
				do {
					int num=rs.getInt("num");
					String title1=rs.getString("title");
					String writer=rs.getString("writer");
					String email=rs.getString("email");
					String content=rs.getString("content");
					Date w_date=rs.getDate("w_date");
					vo=new BoardVo(num,writer,email,title1,content,w_date);
					list.add(vo);
				}while(rs.next());
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//글 수정
	public int update(BoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="update board set title=?,content=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	//수정시 해당 글 가져오기
	public BoardVo select(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getConn();
			String sql="select * from board where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			BoardVo vo=new BoardVo();
			if(rs.next()) {
				String writer=rs.getString("writer");
				String email=rs.getString("email");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date w_date=rs.getDate("w_date");
				vo=new BoardVo(num,writer,email,title,content,w_date);
			}
			return vo;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	
	//글 삭제
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="delete from board where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	//전체글목록(list.jsp)
	public ArrayList<BoardVo> selectAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from board order by num";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<BoardVo> list=new ArrayList<BoardVo>();
			BoardVo vo=new BoardVo();
			if(rs.next()) {
				do {
					int num=rs.getInt("num");
					String writer=rs.getString("writer");
					String email=rs.getString("email");
					String title=rs.getString("title");
					String content=rs.getString("content");
					Date w_date=rs.getDate("w_date");
					vo=new BoardVo(num,writer,email,title,content,w_date);
					list.add(vo);
				}while(rs.next());
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	
	//글쓰기(writeOk.jsp)
	public int insert(BoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into board values(board_seq.nextval,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
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
