package webtoon.chat.dao;

import org.apache.ibatis.session.SqlSession;

import webtoon.chat.vo.ChatVo;

public class ChatDao {

	public int insertChat(SqlSession ss, ChatVo chatVo) {
		return ss.insert("ChatMapper.chat_insert", chatVo);
	}

}//class
