package test.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;
import test.vo.MyBoardVo;

@WebServlet("/board/detail.do")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		MyBoardDao dao=new MyBoardDao();
		MyBoardVo vo=dao.detail(num);
		String content=vo.getContent();
		//textarea�� \n�� �ٹٲ��ϰ� div�� <br>�� �ٹٲ��ϱ� ������ replace�� �̿��ؼ� �ٲ��ش�.
		content=content.replace("\n", "<br>");
		vo.setContent(content);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/board/detail.jsp").forward(req, resp);
	}
}
