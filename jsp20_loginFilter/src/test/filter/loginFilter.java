package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/member/*")
public class loginFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean login=false; //�α����ߴ��� ���θ� ����
		//���ǿ� ���̵� ����Ǿ������� login�� true�� ����ǵ��� �غ�����.
		//ServletRequest�� HttpServletRequest�� �θ�
		//ServletRequest���� getSession�� �����Ƿ� �ڽ��� HttpServletRequest�� ����ȯ
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		if(session!=null) {
			String id=(String)session.getAttribute("id");
			if(id!=null) {
				login=true;
			}
		}
		if(login) {
			chain.doFilter(request, response);
		}else { //�α��� �ȵǾ������� �α����������� �̵��ϱ�(�����̷�Ʈ������� �̵�)
			HttpServletResponse resp=(HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath()+"/login/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
