package test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * << 컨트롤러 >>
 * 1. 사용자의 요청을 분석해서 해당 비즈니스로직을 수행하기 위한 모델객체 호출
 * 2. 모델객체가 보내온 결과값을 스코프에 담기
 * 3. 결과값을 보여줄 뷰 페이지로 이동하기 
 */

@WebServlet("/fortune.do")
public class FortuneController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 사용자의 요청에 따른 모델객체 호출
		String result="동쪽으로 가면 귀인을 만나리~~";
		//2. 모델객체가 보내온 결과값을 스코프에 담기
		req.setAttribute("result", result);
		//3. 결과값을 보여줄 뷰 페이지로 이동하기 
		RequestDispatcher rd= req.getRequestDispatcher("/showFortune.jsp");
		rd.forward(req, resp);
	}
}
