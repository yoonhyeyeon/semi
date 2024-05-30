package webtoon.webtoon.service;

import static webtoon.db.SqlSessionTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.db.JDBCTemplate;
import webtoon.webtoon.dao.WebtoonDao;
import webtoon.webtoon.vo.AttachmentVo;
import webtoon.webtoon.vo.CategoryVo;

public class WebtoonService {

	private final WebtoonDao dao;
	
	public WebtoonService() {
		dao = new WebtoonDao();
	}
	
	public List<CategoryVo> getCategoryVoList() throws Exception {
		//비즈니스 로직
		
		//DAO 호출
		Connection conn = JDBCTemplate.getConnection();
		List<CategoryVo> categoryVoList = dao.getCategoryVoList(conn);
		
		JDBCTemplate.close(conn);
		
		return categoryVoList;
	}
	
	public int insertWebtoonAttachment(List<AttachmentVo> attVoList) throws Exception{
		
		SqlSession ss = getSqlSession();
		int result = dao.insertWebtoonAttachment(ss, attVoList);
		
		if(result >= 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}
	
	
	public List<AttachmentVo> getAttachment(String no) throws Exception {
		
		//DAO 호출
		Connection conn = JDBCTemplate.getConnection();
		List<AttachmentVo> attVoList = dao.getAttachment(conn, no);
		
		JDBCTemplate.close(conn);
		return attVoList;
	}

	
	
}
