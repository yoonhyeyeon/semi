package webtoon.admin.vo;

public class AdminVo {

	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String del_yn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public AdminVo(String no, String id, String pwd, String nick, String del_yn) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.del_yn = del_yn;
	}
	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", del_yn=" + del_yn + "]";
	}
	
	
	
}
