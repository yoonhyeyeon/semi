package webtoon.chat.vo;

public class ChatVo {

	private String no;
	private String refEpisodeNo;
	private String memberNo;
	private String content;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	private String nick;
	
	public ChatVo(String no, String refEpisodeNo, String memberNo, String content, String hit, String enrollDate,
			String modifyDate, String delYn, String nick) {
		super();
		this.no = no;
		this.refEpisodeNo = refEpisodeNo;
		this.memberNo = memberNo;
		this.content = content;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
		this.nick = nick;
	}
	public ChatVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getRefEpisodeNo() {
		return refEpisodeNo;
	}
	public void setRefEpisodeNo(String refEpisodeNo) {
		this.refEpisodeNo = refEpisodeNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "ChatVo [no=" + no + ", refEpisodeNo=" + refEpisodeNo + ", memberNo=" + memberNo + ", content=" + content
				+ ", hit=" + hit + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn=" + delYn
				+ ", nick=" + nick + "]";
	}
	
	
	
}
