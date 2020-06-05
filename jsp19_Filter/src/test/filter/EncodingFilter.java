package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * [ Filter ]
 * - Ŭ���̾�Ʈ�� ��û�� �߰��� ����ä�� ��û�������� �������� Ư�� �۾��� ������.
 *   ���� �� ��û�������� �� ���� �ְ� �ٸ� �������� �̵��� �����ϴ�.
 * - ����� ���
 * 	 1) Filter�������̽��� ��ӹ޾� doFilter�޼ҵ忡�� ó���� �۾��� �����Ѵ�.
 * 	 2) web.xml�� ���͸����� �����ϰų� ������̼����� �����Ѵ�.
 */
public class EncodingFilter implements Filter{
	String encoding;
	//���� ��û�� �� �ѹ��� ȣ��Ǵ� �޼ҵ�
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//filterConfig�� web.xml���� init.param���� ������ ���� ������ �� ����
		System.out.println("init�޼ҵ� ȣ���!!");
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//����ó�� ���� �޼ҵ�
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter�޼ҵ� ȣ���!!!!");
		if(encoding==null) {
			request.setCharacterEncoding("utf-8");
		}else {
			request.setCharacterEncoding(encoding);
		}
		//������ ������ ���Ͱ� �����ϸ� ���͸� �����ϰ� ���̻� ������ ���Ͱ� ������
		//����ڰ� ��û�� �������� �̵�
		chain.doFilter(request, response);
	}

	//�����ð� ��û�� ���� �� Ȥ�� �������� ���� �� ȣ��
	@Override
	public void destroy() {
		System.out.println("destroy�޼ҵ� ȣ���~!~!!");
	}
}
