package webtoon.pay.vo;

public class PayAddVo {
	private String no;
	private String member_no;
	private String bank;
	private String card_no;
	private String card_pwd;
	private String enroll_date;
	private String del_yn;
	public PayAddVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayAddVo(String no, String member_no, String bank, String card_no, String card_pwd, String enroll_date,
			String del_yn) {
		super();
		this.no = no;
		this.member_no = member_no;
		this.bank = bank;
		this.card_no = card_no;
		this.card_pwd = card_pwd;
		this.enroll_date = enroll_date;
		this.del_yn = del_yn;
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
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getCard_pwd() {
		return card_pwd;
	}
	public void setCard_pwd(String card_pwd) {
		this.card_pwd = card_pwd;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	@Override
	public String toString() {
		return "PayAddVo [no=" + no + ", member_no=" + member_no + ", bank=" + bank + ", card_no=" + card_no
				+ ", card_pwd=" + card_pwd + ", enroll_date=" + enroll_date + ", del_yn=" + del_yn + "]";
	}


	
}
