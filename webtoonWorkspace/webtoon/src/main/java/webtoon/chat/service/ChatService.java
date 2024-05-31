package webtoon.chat.service;

import static webtoon.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.chat.dao.ChatDao;
import webtoon.chat.vo.ChatVo;

public class ChatService {

	private final ChatDao dao;
	public ChatService() {
		this.dao = new ChatDao();
	}

	// 댓글 작성
	public int writeChat(ChatVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		int result = dao.writeChat(ss, vo);
		
		if( result == 1 ) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	// 목록조회
	public List<ChatVo> chatList(String refEpisodeNo) throws Exception {
		SqlSession ss = getSqlSession();
		List<ChatVo> voList = dao.chatList(ss, refEpisodeNo);
		ss.close();
		return voList;
		
	}

	public ChatVo getChatVo(ChatVo vo) throws Exception {
		
		SqlSession ss = getSqlSession();
		
		ChatVo voList = dao.getChatVo(ss, vo);
		
		
		ss.close();
		
		return voList;
		
	}

}
