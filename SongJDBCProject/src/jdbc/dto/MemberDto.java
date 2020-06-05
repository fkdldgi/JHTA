package jdbc.dto;

import java.sql.Date;

public class MemberDto {
	
	private String mem_email;
	private String mem_pw;
	private String mem_name;
	private long mem_resnum;
	private long mem_phone;
	private String mem_addr;
	private Date mem_regdate;
	
	public MemberDto(){}

	public MemberDto(String mem_email, String mem_pw, String mem_name, long mem_resnum, long mem_phone, String mem_addr,
			Date mem_regdate) {
		super();
		this.mem_email = mem_email;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_resnum = mem_resnum;
		this.mem_phone = mem_phone;
		this.mem_addr = mem_addr;
		this.mem_regdate = mem_regdate;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public long getMem_resnum() {
		return mem_resnum;
	}

	public void setMem_resnum(long mem_resnum) {
		this.mem_resnum = mem_resnum;
	}

	public long getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(long mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public Date getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(Date mem_regdate) {
		this.mem_regdate = mem_regdate;
	}

	
	
}
