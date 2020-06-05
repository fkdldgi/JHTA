package test.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;
import test.vo.MyBoardVo;

@WebServlet("/board/list.do")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=0;
		int endRow=0;
		endRow=pageNum*5;
		startRow=endRow-3;
		MyBoardDao dao=new MyBoardDao();
		//�������� �ش��ϴ� �� ��� ��������
		ArrayList<MyBoardVo> list=dao.list(startRow,endRow);
		//��ü ������ ���� ���ϱ�
		int pageCount=(int)Math.ceil(dao.getCount()/4.0);
		int startPageNum=0;
		int endPageNum=0;
		//���1
		startPageNum=((pageNum-1)/4)*4+1;
		endPageNum=startPageNum+3;
		if(pageCount<endPageNum) {
			endPageNum=pageCount;
		}
		req.setAttribute("chk", 1);
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);		
	}
}









