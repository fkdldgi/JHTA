package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MembersVo;

public class TestMain1_select {
	public static void main(String[] args) {
		String resource="mybatis/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			//sql������ �����ϱ� ���� SqlSession��ü ������
			SqlSession session=factory.openSession();
			//select������ selectList�޼ҵ�� ȣ��
			List<MembersVo> list=
					session.selectList("mybatis.MembersMapper.select");
			System.out.println("<< ��ü ȸ�� ��� >>");
			for(MembersVo vo:list) {
				System.out.println("ȸ����ȣ: "+vo.getNum());
				System.out.println("ȸ���̸�: "+vo.getName());
				System.out.println("��ȭ��ȣ: "+vo.getPhone());
				System.out.println("�ּ�: "+vo.getAddr());
				System.out.println("������: "+vo.getRegdate());
				System.out.println("------------------------------");
			}
			//��ȸ�� �����Ͱ� 1�� ������ ����(pk) selectOne�޼ҵ� ���
			MembersVo vo1=session.selectOne("mybatis.MembersMapper.getinfo",5);
			if(vo1!=null) {
				System.out.println("<< ��ȸ�� ȸ������ >> ");
				System.out.println("ȸ����ȣ: "+vo1.getNum());
				System.out.println("ȸ���̸�: "+vo1.getName());
				System.out.println("��ȭ��ȣ: "+vo1.getPhone());
				System.out.println("�ּ�: "+vo1.getAddr());
				System.out.println("������: "+vo1.getRegdate());
			}else {
				System.out.println("��ȸ�� ������ �����ϴ�.");
			}
			session.close();
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
