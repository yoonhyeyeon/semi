package webtoon.pay.vo;

public class PayVo {
	private String no;
	private String member_no;
	private String payment_method_no;
	private int pay;
	private String enroll_date;
	public PayVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayVo(String no, String member_no, String payment_method_no, int pay, String enroll_date) {
		super();
		this.no = no;
		this.member_no = member_no;
		this.payment_method_no = payment_method_no;
		this.pay = pay;
		this.enroll_date = enroll_date;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getPayment_method_no() {
		return payment_method_no;
	}
	public void setPayment_method_no(String payment_method_no) {
		this.payment_method_no = payment_method_no;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	@Override
	public String toString() {
		return "PayVo [no=" + no + ", member_no=" + member_no + ", payment_method_no=" + payment_method_no + ", pay="
				+ pay + ", enroll_date=" + enroll_date + "]";
	}
	
}
