package webtoon.freeBoard.service;

import static webtoon.db.JDBCTemplate.close;
import static webtoon.db.JDBCTemplate.getConnection;
import static webtoon.db.SqlSessionTemplate.getSqlSession;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.freeBoard.dao.FreeBoardDao;
import webtoon.freeBoard.vo.FreeBoardVo;
import webtoon.freeBoard.vo.PageVo;


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
	public List<FreeBoardVo> selectFreeBoardList(PageVo pvo) throws Exception {
		
		SqlSession ss = getSqlSession();
		List<FreeBoardVo> voList = dao.selectFreeBoardList(ss, pvo);
		
		ss.close();
		
		return voList;
	}
	public int getBoardCnt() throws Exception {
		
//		SqlSession ss = getSqlSession();
		Connection conn = getConnection();
		int cnt = dao.getFreeBoardCnt(conn);
		
//		ss.close();
		close(conn);
		
		return cnt;
		
	}
	
	// 게시글 상세조회
	public FreeBoardVo getFreeBoardByNo(String no, boolean isSelf) throws Exception {
		
		SqlSession ss = null;
		FreeBoardVo vo = null;
		try {
			ss = getSqlSession();
			
			int result = 1;
			if(!isSelf) {
				result = dao.increaseHit(ss, no);
			}
			vo = dao.getFreeBoardByNo(ss, no);
			if( result == 1 && vo != null) {
				ss.commit();
			}else {
				ss.rollback();
				throw new Exception("게시글 조회수 증가 실패");
			}
		}finally {
			ss.close();
		}
		return vo;
	}

}
