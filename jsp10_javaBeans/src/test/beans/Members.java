package test.beans;
/*
 * 자바빈즈
 * - 전달되는 파라미터와 같은 이름으로 멤버변수 만들기
 * - setter,getter 메소드 ㅏㅁㄴ들기
 * - 디폴트생성자 만들기
 * - 위와 같은 규칙으로 생성된 객체를 자바빈즈라고 함
 * 
 * 
 */

public class Members {
	private String name;
	private String phone;
	private String addr;
	
	public Members() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
}
