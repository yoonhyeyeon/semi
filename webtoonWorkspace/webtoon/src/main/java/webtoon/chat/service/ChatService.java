package webtoon.chat.service;

import org.apache.ibatis.session.SqlSession;
import static webtoon.db.SqlSessionTemplate.*;

import webtoon.chat.dao.ChatDao;
import webtoon.chat.vo.ChatVo;

public class ChatService {

	private final ChatDao dao;
	public ChatService() {
		this.dao = new ChatDao();
	}
	
	public int insertChat(ChatVo chatVo) throws Exception {
		
		SqlSession ss = getSqlSession();
		int result = dao.insertChat(ss, chatVo);
		
		if( result == 1 ) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

}//class
