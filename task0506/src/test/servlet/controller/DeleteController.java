package test.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd=req.getParameter("pwd");
		String inputPwd=req.getParameter("inputPwd");
		int num=Integer.parseInt(req.getParameter("num"));
		MyBoardDao dao=new MyBoardDao();
		int n=0;
		//�Է��� ��й�ȣ�� ������ ���� ��й�ȣ�� ��ġ�ϸ� ����
		if(pwd.equals(inputPwd)) {
			n=dao.delete(num);
		}
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/board/list.do");
		}else {
			
		}
	}
}
