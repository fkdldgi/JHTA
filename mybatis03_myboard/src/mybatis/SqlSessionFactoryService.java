package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource="mybatis/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
