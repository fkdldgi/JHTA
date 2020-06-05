package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlSessionFactoryService;
import test.vo.MyBoardVo;

public class MyBoardDao {
	private SqlSessionFactory sqlSessionFactory=
						SqlSessionFactoryService.getSqlSessionFactory();
	private static final String NAMESPACE="mybatis.MyBoardMapper"; //mapper �����±׸��� ���Ծ������� ����� ����
	public int insert(MyBoardVo vo) {
		SqlSession sqlSession=null;
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.insert(NAMESPACE+".insert",vo);
			sqlSession.commit();
			return n;
		}finally {
			if(sqlSession!=null) sqlSession.close(); //������ ������ ��������ϹǷ� try,finally ���
		}
	}
	public List<MyBoardVo> selectList(){
		SqlSession sqlSession=null;
		try {
			sqlSession=sqlSessionFactory.openSession();
			List<MyBoardVo> list=sqlSession.selectList(NAMESPACE+".select");
			return list;
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	public int delete(int num) {
		SqlSession sqlSession=null;
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.delete(NAMESPACE+".delete",num);
			sqlSession.commit();
			return n;
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	public int update(MyBoardVo vo) {
		SqlSession sqlSession=null;
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.update(NAMESPACE+".update",vo);
			sqlSession.commit();
			return n;
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
}
