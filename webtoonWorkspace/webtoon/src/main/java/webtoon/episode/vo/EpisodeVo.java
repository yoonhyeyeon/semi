package webtoon.episode.vo;

public class EpisodeVo {

	private String no;
	private String webtoonName;
	private String title;
	private String writer;
	private String enrollDate;
	private String profile;
	
	public EpisodeVo(String no, String webtoonName, String title, String writer, String enrollDate, String profile) {
		super();
		this.no = no;
		this.webtoonName = webtoonName;
		this.title = title;
		this.writer = writer;
		this.enrollDate = enrollDate;
		this.profile = profile;
	}
	public EpisodeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWebtoonName() {
		return webtoonName;
	}
	public void setWebtoonName(String webtoonName) {
		this.webtoonName = webtoonName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "EpisodeVo [no=" + no + ", webtoonName=" + webtoonName + ", title=" + title + ", writer=" + writer
				+ ", enrollDate=" + enrollDate + ", profile=" + profile + "]";
	}
	
}
