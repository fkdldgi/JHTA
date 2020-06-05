package jdbc.dto;

public class AccountDto {
	private long ac_num; //���¹�ȣ
	private String mem_email; //�̸���(����Ű)
	private int ac_pw; //���º�й�ȣ
	private long ac_money; //�����ܾ�
	private String ac_bname; //�����
	
	public AccountDto(){}

	public AccountDto(long ac_num, String mem_email, int ac_pw, long ac_money, String ac_bname) {
		super();
		this.ac_num = ac_num;
		this.mem_email = mem_email;
		this.ac_pw = ac_pw;
		this.ac_money = ac_money;
		this.ac_bname = ac_bname;
	}

	public long getAc_num() {
		return ac_num;
	}

	public void setAc_num(long ac_num) {
		this.ac_num = ac_num;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public int getAc_pw() {
		return ac_pw;
	}

	public void setAc_pw(int ac_pw) {
		this.ac_pw = ac_pw;
	}

	public long getAc_money() {
		return ac_money;
	}

	public void setAc_money(long ac_money) {
		this.ac_money = ac_money;
	}

	public String getAc_bname() {
		return ac_bname;
	}

	public void setAc_bname(String ac_bname) {
		this.ac_bname = ac_bname;
	}
	
}
