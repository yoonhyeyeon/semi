package webtoon.chat.vo;

public class ChatVo {

	private String no;
	private String ref_episode_no;
	private String member_no;
	private String content;
	private String hit;
	private String enroll_date;
	private String modify_date;
	private String del_yn;
	
	public ChatVo(String no, String ref_episode_no, String member_no, String content, String hit, String enroll_date,
			String modify_date, String del_yn) {
		super();
		this.no = no;
		this.ref_episode_no = ref_episode_no;
		this.member_no = member_no;
		this.content = content;
		this.hit = hit;
		this.enroll_date = enroll_date;
		this.modify_date = modify_date;
		this.del_yn = del_yn;
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
	public String getRef_episode_no() {
		return ref_episode_no;
	}
	public void setRef_episode_no(String ref_episode_no) {
		this.ref_episode_no = ref_episode_no;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
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
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	@Override
	public String toString() {
		return "ChatVo [no=" + no + ", ref_episode_no=" + ref_episode_no + ", member_no=" + member_no + ", content="
				+ content + ", hit=" + hit + ", enroll_date=" + enroll_date + ", modify_date=" + modify_date
				+ ", del_yn=" + del_yn + "]";
	}
	
	
	
}
