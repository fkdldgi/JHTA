package jdbc.dto;

import java.sql.Date;

public class TransactionDto {
	private int tr_num;
	private long wdac_num;
	private long deac_num;
	private Date tr_date;
	private long tr_money;
	private long tr_afmoney;
	private String tr_name;
	
	public TransactionDto() {}

	public TransactionDto(int tr_num, long wdac_num, long deac_num, Date tr_date, long tr_money, long tr_afmoney,
			String tr_name) {
		super();
		this.tr_num = tr_num;
		this.wdac_num = wdac_num;
		this.deac_num = deac_num;
		this.tr_date = tr_date;
		this.tr_money = tr_money;
		this.tr_afmoney = tr_afmoney;
		this.tr_name = tr_name;
	}

	public int getTr_num() {
		return tr_num;
	}

	public void setTr_num(int tr_num) {
		this.tr_num = tr_num;
	}

	public long getWdac_num() {
		return wdac_num;
	}

	public void setWdac_num(long wdac_num) {
		this.wdac_num = wdac_num;
	}

	public long getDeac_num() {
		return deac_num;
	}

	public void setDeac_num(long deac_num) {
		this.deac_num = deac_num;
	}

	public Date getTr_date() {
		return tr_date;
	}

	public void setTr_date(Date tr_date) {
		this.tr_date = tr_date;
	}

	public long getTr_money() {
		return tr_money;
	}

	public void setTr_money(long tr_money) {
		this.tr_money = tr_money;
	}

	public long getTr_afmoney() {
		return tr_afmoney;
	}

	public void setTr_afmoney(long tr_afmoney) {
		this.tr_afmoney = tr_afmoney;
	}

	public String getTr_name() {
		return tr_name;
	}

	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}
}
