package webtoon.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import webtoon.chat.vo.ChatVo;

public class ChatDao {
	private static ChatDao dao = new ChatDao();
	private ChatDao() {}
	public static ChatDao getInstance() {
		return dao;
	}
	
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	//chat 테이블 no 로 데이터 한개 가져오기
	public ChatVo getOne(String no) throws Exception{
		ChatVo vo = new ChatVo();
		String sql = "SELECT * FROM CHAT WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		vo.setNo("NO");
		vo.setMemberNo("MEMBER_NO");
		vo.setRefEpisodeNo("REF_EPISODE_NO");
		vo.setContent("CONTENT");
		vo.setHit("HIT");
		vo.setEnrollDate("ENROLL_DATE");
		vo.setModifyDate("MODIFY_DATE");
		vo.setDelYn("DEL_YN");
		
		pstmt.close();
		return vo;
	}

	// chat 테이블 no 데이터 수정
	public void update(ChatVo vo) throws Exception{
		String sql = "UPDATE CHAT SET CONTENT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getContent());
		pstmt.setString(2, vo.getNo());
		pstmt.execute();
		pstmt.close();
		
	}
	
	// chat 테이블  no 데이터 삭제
	public void delete(String no) throws Exception{
		String sql = "UPDATE CHAT DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.execute();
		pstmt.close();
	}
	
	// 댓글 추가
	public void insert(ChatVo vo) throws Exception{
		String sql = "INSERT INTO CHAT(NO, REF_EPISODE_NO, MEMBER_NO , CONTENT) VALUES (SEQ_CHAT_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getRefEpisodeNo());
		pstmt.setString(2, vo.getMemberNo());
		pstmt.setString(3, vo.getContent());
		pstmt.execute();
		pstmt.close();
	}
	
	// 댓글 리스트
	public int getCount(String no) throws Exception{
		String sql = "SELECT COUNT(*) FROM CHAT WHERE REF_EPISODE_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		int cnt = 0;
		if( rs.next() ) {
			cnt = rs.getInt(1);
		}
		pstmt.close();
		return cnt;
	}
	
	public ArrayList<ChatVo> getList(String refEpisodeNo) throws Exception{
		ArrayList<ChatVo> list = new ArrayList<>();
		
		String sql = "SELECT * FROM CHAT WHERE REF_EPISODE_NO = ? ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, refEpisodeNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			do {
				ChatVo vo = new ChatVo();
				vo.setNo(rs.getString("NO"));
				vo.setRefEpisodeNo(rs.getString("REF_EPISODE_NO"));
				vo.setMemberNo(rs.getString("MEMBER_NO"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setHit(rs.getString("HIT"));
				vo.setEnrollDate(rs.getString("ENROLL_DATE"));
				vo.setModifyDate(rs.getString("MODIFY_DATE"));
				vo.setDelYn(rs.getString("DEL_YN"));
				list.add(vo);
			}while(rs.next());
		}
		pstmt.close();
		return list;
	}//method

}//class
