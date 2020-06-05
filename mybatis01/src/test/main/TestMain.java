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
			//sql������ �����ϱ� ���� SqlSession��ü ������
			SqlSession session=factory.openSession();
			MembersVo vo=new MembersVo(2,null,"112","��õ",null);
//			int n=session.insert("insert",vo);
//			session.commit(); //Ŀ���ϱ�
//			System.out.println(n+"���� ȸ���߰�!");
//			int n1=session.delete("mybatis.MembersMapper.delete",1);
//			System.out.println(n1+"�� ȸ������!");
//			session.commit();
			int n2=session.update("mybatis.MembersMapper.update",vo);//Mapper.xml���Ͽ� mapper namespace�� ������ �̸�(�浹����)
			System.out.println(n2+"�� ȸ������ ����!");
			session.commit();
			session.close(); //���� �����ϱ�(db��������)
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
