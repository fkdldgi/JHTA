package test.servlet.controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;
import test.vo.MyBoardVo;

@WebServlet("/board/search.do")
public class SearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=0;
		int endRow=0;
		endRow=pageNum*4;
		startRow=endRow-3;
		String schkbox=req.getParameter("chkbox");
		int chkbox=0;
		if(schkbox!=null) {
			chkbox=Integer.parseInt(schkbox);
		}
		String search=req.getParameter("search");
		MyBoardDao dao=new MyBoardDao();
		ArrayList<MyBoardVo> list=dao.search(startRow,endRow,chkbox,search);
		//전체 페이지 갯수 구하기
		int pageCount=(int)Math.ceil(dao.searchCnt(chkbox, search)/4.0);
		int startPageNum=0;
		int endPageNum=0;
		//방법1
		startPageNum=((pageNum-1)/4)*4+1;
		endPageNum=startPageNum+3;
		if(pageCount<endPageNum) {
			endPageNum=pageCount;
		}
		req.setAttribute("chk", 2);
		req.setAttribute("list", list);
		req.setAttribute("chkbox", chkbox);
		req.setAttribute("search", search);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
}
