package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.dao.MyUsersDao;
import test.vo.MyUsersVo;

@WebServlet("/myusers/select")
public class MyUsersSelect  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sregdate=req.getParameter("regdate");
		sregdate=sregdate.substring(2,sregdate.length());
		String regdate=sregdate.replaceAll("-", "/");
		MyUsersDao dao=new MyUsersDao();
		ArrayList<MyUsersVo> list=dao.select(regdate);
		JSONArray jarr=new JSONArray();
		for(MyUsersVo vo:list) {
			JSONObject json=new JSONObject();
			json.put("id",vo.getId());
			json.put("pwd",vo.getPwd());
			json.put("email", vo.getEmail());
			json.put("regdate",vo.getRegdate());
			jarr.put(json);
		}
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(jarr);
	}
}
