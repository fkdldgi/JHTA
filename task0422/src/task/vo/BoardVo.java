package task.vo;

import java.sql.Date;

public class BoardVo {
	private int num;
	private String writer;
	private String email;
	private String title;
	private String content;
	private Date w_date;
	
	public BoardVo() {}

	public BoardVo(int num, String writer, String email, String title, String content, Date w_date) {
		this.num = num;
		this.writer = writer;
		this.email = email;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	
	
}
