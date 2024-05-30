package webtoon.webtoon.vo;

public class WebtoonVo {

	private String no;
	private String genreNo;
	private String name;
	private String day;
	private String hit;
	private String great;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(String genreNo) {
		this.genreNo = genreNo;
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
	public WebtoonVo(String no, String genreNo, String name, String day, String hit, String great, String enrollDate,
			String modifyDate, String delYn) {
		super();
		this.no = no;
		this.genreNo = genreNo;
		this.name = name;
		this.day = day;
		this.hit = hit;
		this.great = great;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
	}
	public WebtoonVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WebtoonVo [no=" + no + ", genreNo=" + genreNo + ", name=" + name + ", day=" + day + ", hit=" + hit
				+ ", great=" + great + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn=" + delYn
				+ "]";
	}
	
	
	
}
