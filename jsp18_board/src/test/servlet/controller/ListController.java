package test.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.BoardDao;
import test.vo.BoardVo;

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
		//방법1
		endRow=pageNum*10;
		startRow=endRow-9;
		//방법2
//		startRow=(pageNum-1)*10+1;
//		endRow=startRow+9;
		BoardDao dao=new BoardDao();
		//페이지에 해당하는 글 목록 가져오기
		ArrayList<BoardVo> list=dao.list(startRow,endRow);
		//전체 페이지 갯수 구하기
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);
		int startPageNum=0;
		int endPageNum=0;
		//방법1
		startPageNum=((pageNum-1)/10)*10+1;
		endPageNum=startPageNum+9;
		if(pageCount<endPageNum) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);		
	}
}









