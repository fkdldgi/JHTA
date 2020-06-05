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
			//sql������ �����ϱ� ���� SqlSession��ü ������
			SqlSession session=factory.openSession();
			//��ü��ȸ
			List<MyUsersVo> list=session.selectList("mybatis.MyUsersMapper.select");
			System.out.println("<< ��üȸ������ >>");
			for(MyUsersVo vo:list) {
				System.out.println("���̵�: "+vo.getId());
				System.out.println("��й�ȣ: "+vo.getPwd());
				System.out.println("�̸���: "+vo.getEmail());
				System.out.println("������: "+vo.getEmail());
				System.out.println("-------------------------");
			}
//			session.close();
			
			//���̵�� ��ȸ
			MyUsersVo vo1=session.selectOne("mybatis.MyUsersMapper.getinfo","fkdldgi");
			if(vo1!=null) {
				System.out.println("<< �˻��� ȸ������ >>");
				System.out.println("���̵�: "+vo1.getId());
				System.out.println("��й�ȣ: "+vo1.getPwd());
				System.out.println("�̸���: "+vo1.getEmail());
				System.out.println("������: "+vo1.getEmail());
			}
			session.close();
			
			//������ �߰�
//			MyUsersVo vo2=new MyUsersVo("test3","2222","test3@naver.com",null);
//			int n=session.insert("mybatis.MyUsersMapper.insert",vo2);
//			System.out.println(n+"���� ȸ�� �߰�!");
//			session.commit();
//			session.close();
			
			//������ ����
//			MyUsersVo vo3=new MyUsersVo("as","5678","result@daum.net",null);
//			int n=session.update("mybatis.MyUsersMapper.update",vo3);
//			System.out.println(n+"���� ȸ������ ����!");
//			session.commit();
//			session.close();
			
			//������ ����
//			int n=session.delete("mybatis.MyUsersMapper.delete","as");
//			System.out.println(n+"���� ȸ�� ����!");
//			session.commit();
//			session.close();
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
