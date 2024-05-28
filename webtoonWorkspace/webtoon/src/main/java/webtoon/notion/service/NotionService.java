package webtoon.notion.service;

import static webtoon.db.JDBCTemplate.close;
import static webtoon.db.JDBCTemplate.commit;
import static webtoon.db.JDBCTemplate.getConnection;
import static webtoon.db.JDBCTemplate.rollback;
import static webtoon.db.SqlSessionTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.notion.dao.NotionDao;
import webtoon.notion.vo.NotionVo;
import webtoon.notion.vo.PageVo;

public class NotionService {

	private final NotionDao dao;

	public NotionService() {
		this.dao = new NotionDao();
	}

	// 게시글 작성
	public int NotionInsert(NotionVo vo) throws Exception {
		// 비즈니스 로직

		// DAO 호출
		SqlSession ss = getSqlSession();
//		Connection conn = getConnection(); 
		int result = dao.NotionInsert(ss, vo);

		if (result == 1) {
			ss.commit();
//			commit(conn);
		} else {
			ss.rollback();
//			rollback(conn);
		}

		ss.close();
//		close(conn);

		return result;
	}

	// 게시글 목록 조회
	public List<NotionVo> getNotionList(PageVo pvo) throws Exception {

		SqlSession ss = getSqlSession();

//		Connection conn = getConnection();
		List<NotionVo> voList = dao.getNotionList(ss, pvo);

		ss.close();
//		close(conn);

		return voList;
	}

	public int getNotionCnt() throws Exception {

		Connection conn = getConnection();
		int cnt = dao.getNotionCnt(conn);

		close(conn);

		return cnt;
	}

	// 게시글 상세 조회

	public NotionVo getNotionByNo(String no) throws Exception {

//		Connection conn = getConnection();
		SqlSession ss = getSqlSession();

		NotionVo vo = dao.getNotionByNo(ss, no);

//		close(conn);
		ss.close();

		return vo;

	}

	// 게시글 수정
	public int edit(NotionVo vo) throws Exception {

		// 비즈니스 로직

		// dao
//		Connection conn = getConnection();
		SqlSession ss = getSqlSession();

		int result = dao.edit(ss, vo);

		if (result == 1) {
//			commit(conn);
			ss.commit();
		} else {
//			rollback(conn);
			ss.rollback();
		}

//		close(conn);
		ss.close();

		return result;
	}

	// 게시글 삭제
	public int delete(NotionVo notionVo) throws Exception {

//		Connection conn = getConnection();
		SqlSession ss = getSqlSession();

		int result = dao.delete(ss, notionVo);

		if (result == 1) {
//			commit(conn);
			ss.commit();
		} else {
//			rollback(conn);
			ss.rollback();
			throw new Exception("게시글 삭제 실패");
		}

//		close(conn);
		ss.close();

		return result;

	}

}// class
