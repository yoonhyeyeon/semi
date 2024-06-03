package webtoon.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static webtoon.db.JDBCTemplate.*;
import org.apache.ibatis.session.SqlSession;

import webtoon.chat.vo.ChatVo;

public class ChatDao {

	public int writeChat(SqlSession ss, ChatVo vo) throws Exception {
//		System.out.println("dao vo : " + vo);
		return ss.insert("ChatMapper.chatWirte", vo);
		
//		String sql = "INSERT INTO CHAT ( NO , REF_EPISODE_NO , MEMBER_NO , CONTENT ) VALUES ( SEQ_CHAT_NO.NEXTVAL , ?, ?, ? )";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getRefEpisodeNo());
//		pstmt.setString(2, vo.getMemberNo());
//		pstmt.setString(3, vo.getContent());
//		
//		int result = pstmt.executeUpdate();
//		
//		close(pstmt);
//		
//		return result;
		
	}

	public List<ChatVo> chatList(SqlSession ss, String refEpisodeNo) {
		return ss.selectList("ChatMapper.chatList", refEpisodeNo);
	}

}//class
