package webtoon.chat.service;

import static webtoon.db.SqlSessionTemplate.getSqlSession;
import static webtoon.db.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.chat.dao.ChatDao;
import webtoon.chat.vo.ChatVo;
import webtoon.db.JDBCTemplate;
import webtoon.notion.vo.NotionVo;

public class ChatService {

	private final ChatDao dao;
	public ChatService() {
		this.dao = new ChatDao();
	}

	// 댓글 작성
	public int writeChat(ChatVo vo) throws Exception {
		SqlSession ss = getSqlSession();
//		Connection conn = getConnection();
		int result = dao.writeChat(ss, vo);
		
		if( result == 1 ) {
			ss.commit();
//			commit(conn);
		}else {
			ss.rollback();
//			rollback(conn);
		}
		ss.close();
//		close(conn);
		return result;
	}

	// 목록조회
	public List<ChatVo> chatList(String refEpisodeNo) throws Exception {
		SqlSession ss = getSqlSession();
		List<ChatVo> voList = dao.chatList(ss, refEpisodeNo);
		ss.close();
		return voList;
		
	}

}
