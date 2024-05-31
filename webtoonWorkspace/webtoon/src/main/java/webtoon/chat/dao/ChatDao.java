package webtoon.chat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.chat.vo.ChatVo;

public class ChatDao {

	public int writeChat(SqlSession ss, ChatVo vo) {
		System.out.println("dao > vo : " + vo);
		return ss.insert("ChatMapper.chatWirte", vo);
	}

	public List<ChatVo> chatList(SqlSession ss, String refEpisodeNo) {
		return ss.selectList("ChatMapper.chatList", refEpisodeNo);
	}


	public ChatVo getChatVo(SqlSession ss , ChatVo vo) {
		return ss.selectOne("ChatMapper.getChat" , vo);
	}

}//class
