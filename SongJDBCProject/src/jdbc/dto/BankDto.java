package jdbc.dto;

public class BankDto {
	private String ac_bname;
	private String bk_path;
	public BankDto() {}
	public BankDto(String ac_bname, String bk_path) {
		super();
		this.ac_bname = ac_bname;
		this.bk_path = bk_path;
	}
	public String getAc_bname() {
		return ac_bname;
	}
	public void setAc_bname(String ac_bname) {
		this.ac_bname = ac_bname;
	}
	public String getBk_path() {
		return bk_path;
	}
	public void setBk_path(String bk_path) {
		this.bk_path = bk_path;
	}
	
}
