package webtoon.freeBoard.service;

import static webtoon.db.SqlSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import webtoon.freeBoard.dao.FreeBoardDao;
import webtoon.freeBoard.vo.FreeBoardVo;


public class FreeBoardService {

	private final FreeBoardDao dao;
	public FreeBoardService() {
		this.dao = new FreeBoardDao();
	}
	// 게시글 작성
	public int FreeBoardInsert(FreeBoardVo vo) throws Exception {
		
		SqlSession ss = getSqlSession();
		int result = dao.insert(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

}
