package webtoon.freeBoard.dao;

import org.apache.ibatis.session.SqlSession;

import webtoon.freeBoard.vo.FreeBoardVo;

public class FreeBoardDao {

	// 게시글 작성
	public int insert(SqlSession ss, FreeBoardVo vo) {
		return ss.insert("FreeBoardMapper.freeBoard_insert", vo);
	}

	
	
}//class
