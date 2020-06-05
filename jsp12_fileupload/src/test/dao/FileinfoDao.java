package test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.JDBCUtil;
import test.vo.FileinfoVo;

import java.sql.Connection;

public class FileinfoDao {
	//������ ���� �ֱ�
	public int update(FileinfoVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="update fileinfo set title=?,content=?,orgfilename=?,savefilename=?,filesize=? where filenum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getOrgfilename());
			pstmt.setString(4, vo.getSavefilename());
			pstmt.setLong(5, vo.getFilesize());
			pstmt.setInt(6, vo.getFilenum());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	//���Ϲ�ȣ�� ���� ���� ������
	public FileinfoVo select(int filenum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from fileinfo where filenum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, filenum);
			rs=pstmt.executeQuery();
			FileinfoVo vo=new FileinfoVo();
			if(rs.next()) {
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String orgfilename=rs.getString("orgfilename");
				String savefilename=rs.getString("savefilename");
				long filesize=rs.getLong("filesize");
				vo=new FileinfoVo(filenum,writer,title,content,orgfilename,savefilename,filesize);
			}
			return vo;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//���ϻ���
	public int delete(int filenum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="delete from fileinfo where filenum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, filenum);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}
	}
	//���� ��� ��������
	public String selectPath(int filenum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String savefilename="";
		try {
			con=JDBCUtil.getConn();
			String sql="select savefilename from fileinfo where filenum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, filenum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				savefilename=rs.getString("savefilename");
			}
			return savefilename;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return "";
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	//���ϸ�Ϻ���
	public ArrayList<FileinfoVo> selectAll(){
		ArrayList<FileinfoVo> list=new ArrayList<FileinfoVo>();
		FileinfoVo vo=new FileinfoVo();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from fileinfo order by filenum";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int filenum=rs.getInt("filenum");
					String writer=rs.getString("writer");
					String title=rs.getString("title");
					String content=rs.getString("content");
					String orgfilename=rs.getString("orgfilename");
					String savefilename=rs.getString("savefilename");
					long filesize=rs.getLong("filesize");
					vo=new FileinfoVo(filenum,writer,title,content,orgfilename,savefilename,filesize);
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
	
	//���Ͼ��ε�
	public int insert(FileinfoVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into fileinfo values(fileinfo_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getOrgfilename());
			pstmt.setString(5, vo.getSavefilename());
			pstmt.setLong(6, vo.getFilesize());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
}
