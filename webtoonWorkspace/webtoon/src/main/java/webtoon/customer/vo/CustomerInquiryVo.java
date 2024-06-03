package webtoon.customer.vo;

public class CustomerInquiryVo {

	private String inquiryNo;
	private String memberNo;
	private String title;
	private String content;
	private String enrollDate;
	public String getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(String inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public CustomerInquiryVo(String inquiryNo, String memberNo, String title, String content, String enrollDate) {
		super();
		this.inquiryNo = inquiryNo;
		this.memberNo = memberNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
	}
	public CustomerInquiryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerVo [inquiryNo=" + inquiryNo + ", memberNo=" + memberNo + ", title=" + title + ", content="
				+ content + ", enrollDate=" + enrollDate + "]";
	}

	
	
}
