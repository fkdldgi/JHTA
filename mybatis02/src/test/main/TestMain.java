package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MyUsersVo;

public class TestMain {
	public static void main(String[] args) {
		String resource="mybatis/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			//sql구문을 실행하기 위한 SqlSession객체 얻어오기
			SqlSession session=factory.openSession();
			//전체조회
			List<MyUsersVo> list=session.selectList("mybatis.MyUsersMapper.select");
			System.out.println("<< 전체회원정보 >>");
			for(MyUsersVo vo:list) {
				System.out.println("아이디: "+vo.getId());
				System.out.println("비밀번호: "+vo.getPwd());
				System.out.println("이메일: "+vo.getEmail());
				System.out.println("가입일: "+vo.getEmail());
				System.out.println("-------------------------");
			}
//			session.close();
			
			//아이디로 조회
			MyUsersVo vo1=session.selectOne("mybatis.MyUsersMapper.getinfo","fkdldgi");
			if(vo1!=null) {
				System.out.println("<< 검색한 회원정보 >>");
				System.out.println("아이디: "+vo1.getId());
				System.out.println("비밀번호: "+vo1.getPwd());
				System.out.println("이메일: "+vo1.getEmail());
				System.out.println("가입일: "+vo1.getEmail());
			}
			session.close();
			
			//데이터 추가
//			MyUsersVo vo2=new MyUsersVo("test3","2222","test3@naver.com",null);
//			int n=session.insert("mybatis.MyUsersMapper.insert",vo2);
//			System.out.println(n+"명의 회원 추가!");
//			session.commit();
//			session.close();
			
			//데이터 수정
//			MyUsersVo vo3=new MyUsersVo("as","5678","result@daum.net",null);
//			int n=session.update("mybatis.MyUsersMapper.update",vo3);
//			System.out.println(n+"명의 회원정보 수정!");
//			session.commit();
//			session.close();
			
			//데이터 삭제
//			int n=session.delete("mybatis.MyUsersMapper.delete","as");
//			System.out.println(n+"명의 회원 삭제!");
//			session.commit();
//			session.close();
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
