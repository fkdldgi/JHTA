package test.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.FileinfoDao;
import test.vo.FileinfoVo;

@WebServlet("/filedownload")
public class FileDownloadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int filenum=Integer.parseInt(req.getParameter("filenum"));
		FileinfoDao dao=new FileinfoDao();
		//다운로드할 파일 정보 얻어오기
		FileinfoVo vo=dao.select(filenum);
		//파일명이 한글인 경우 깨지지 않도록 인코딩 설정
		String filename=URLEncoder.encode(vo.getOrgfilename(),"utf-8");
		//파일명에 공백이 있을경우 utf-8에서는 +로 바뀌는데 그것을 공백으로 바꿔줌
		filename=filename.replaceAll("\\+","%20"); //정규표현식에서 예약어인 "+"를 쓸 수 없기 때문에 이스케이프문 "\\+"로 표현  %20:utf-8에서 공백을 나타냄
		
		//1. 다운로드창으로 응답하기
		resp.setContentType("application/octet-stream");
		resp.setContentLengthLong(vo.getFilesize());
		resp.setHeader("Content-Disposition", "attachment;filename="+filename); //("이름","벨류");
		
		//2. 클라이언트에 파일 보내기(파일복사)
		//application은 jsp내장객체여서 바로 못쓰기떄문에 req.getServletContext()로 얻어옴
		ServletContext application=req.getServletContext(); //application의 자료형은 ServletContext
		String upload=application.getRealPath("/upload");
		//File.separator 는 운영체제에 따라 \가 1개 또는 2개일 수 있어서 자동으로 \를 넣어줌
		FileInputStream fis=new FileInputStream(upload+File.separator+vo.getSavefilename());
		//클라이언트에 파일데이터를 전송(출력)하기 위한 스트림 객체
		OutputStream os=resp.getOutputStream();
		BufferedInputStream bis=new BufferedInputStream(fis); //버퍼기능을 이용해서 성능 향상
		BufferedOutputStream bos=new BufferedOutputStream(os); //버퍼기능을 이용해서 성능 향상
		byte[] b=new byte[1024];
		int n=0;
		while((n=bis.read(b))!=-1) {
			bos.write(b, 0, n);
		}
		bos.close();
		bis.close();
	}
}






