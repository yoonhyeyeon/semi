package webtoon.home.vo;

public class HomeVo {

	private String no;
	private String genre_no;
	private String profile;
	private String name;
	private String day;
	private String hit;
	private String great;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	
	public HomeVo(String no, String genre_no, String profile, String name, String day, String hit, String great,
			String enrollDate, String modifyDate, String delYn) {
		super();
		this.no = no;
		this.genre_no = genre_no;
		this.profile = profile;
		this.name = name;
		this.day = day;
		this.hit = hit;
		this.great = great;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
	}
	public HomeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGenre_no() {
		return genre_no;
	}
	public void setGenre_no(String genre_no) {
		this.genre_no = genre_no;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getGreat() {
		return great;
	}
	public void setGreat(String great) {
		this.great = great;
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
	@Override
	public String toString() {
		return "HomeVo [no=" + no + ", genre_no=" + genre_no + ", profile=" + profile + ", name=" + name + ", day="
				+ day + ", hit=" + hit + ", great=" + great + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", delYn=" + delYn + "]";
	}
	
	
}
