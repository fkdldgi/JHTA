package test.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MembersVo;

public class TestMain {
	public static void main(String[] args) {
		String resource="mybatis/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			//sql구문을 실행하기 위한 SqlSession객체 얻어오기
			SqlSession session=factory.openSession();
			MembersVo vo=new MembersVo(2,null,"112","인천",null);
//			int n=session.insert("insert",vo);
//			session.commit(); //커밋하기
//			System.out.println(n+"명의 회원추가!");
//			int n1=session.delete("mybatis.MembersMapper.delete",1);
//			System.out.println(n1+"명 회원삭제!");
//			session.commit();
			int n2=session.update("mybatis.MembersMapper.update",vo);//Mapper.xml파일에 mapper namespace로 지정한 이름(충돌방지)
			System.out.println(n2+"명 회원정보 수정!");
			session.commit();
			session.close(); //세션 종료하기(db접속해제)
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
