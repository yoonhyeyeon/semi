package webtoon.home.service;

import static webtoon.db.SqlSessionTemplate.getSqlSession;
import static webtoon.db.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.home.dao.HomeDao;
import webtoon.home.vo.HomeVo;
import webtoon.home.vo.PageVo;
import webtoon.webtoon.vo.AttachmentVo;
import webtoon.webtoon.vo.CategoryVo;

public class HomeService {

	private final HomeDao dao;
	public HomeService() {
		this.dao = new HomeDao();
	}
	
	public List<HomeVo> HomeList(PageVo pvo) throws Exception {
//		SqlSession ss = getSqlSession();
		Connection conn = getConnection();
		
		List<HomeVo> voList = dao.HomeList(conn, pvo);
//		ss.close();
		close(conn);
		
		return voList;
		
		
	}

	public int getHomeCnt() throws Exception {
		Connection conn = getConnection();
		int cnt = dao.getHomeCnt(conn);
		
		close(conn);
		
		return cnt;
		
	}

	public int HomeInsert(HomeVo vo) throws Exception {
		
//		SqlSession ss = getSqlSession();
		Connection conn = getConnection();
		int result = dao.HomeInsert(conn, vo);
		
//		int attResult = 1;
//		if(voList.size() > 0) {
//			attResult = dao.insertAttachment(ss, voList);
//		}
//		
//		if(result * attResult >= 1) {
//			ss.commit();
//		}else {
//			ss.rollback();
//		}
//		ss.close();
		
		if( result == 1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public List<CategoryVo> getCategoryVoList() throws Exception {
		Connection conn = getConnection();
		List<CategoryVo> categoryVoList = dao.getCategoryVoList(conn);
		
		close(conn);
		
		return categoryVoList;
		
	}


}
