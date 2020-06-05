package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MembersDao;
import test.vo.MembersVo;

@WebServlet("/members/updateOk.do")
public class UpdateOkController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		MembersDao dao=new MembersDao();
		MembersVo vo=new MembersVo(num,name,phone,addr,null);
		try {
			int n=dao.update(vo);
			resp.sendRedirect(req.getContextPath()+"/members/list.do");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", "회원정보 수정 실패!!");
			req.getRequestDispatcher("/members/error.jsp").forward(req, resp);
		}
	}
}
