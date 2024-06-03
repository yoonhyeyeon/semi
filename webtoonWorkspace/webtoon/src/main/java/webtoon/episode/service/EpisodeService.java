package webtoon.episode.service;

import static webtoon.db.SqlSessionTemplate.getSqlSession;
import static webtoon.db.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.episode.dao.EpisodeDao;
import webtoon.episode.vo.EpisodeVo;
import webtoon.webtoon.vo.CategoryVo;

public class EpisodeService {

	private final EpisodeDao dao;
	public EpisodeService() {
		this.dao = new EpisodeDao();
	}
	
	
	public List<EpisodeVo> EpisodeList() throws Exception {
		
		SqlSession ss = getSqlSession();
		
		List<EpisodeVo> voList = dao.EpisodeList(ss);
		
		ss.close();
		return voList;
	}


	public int episodeInsert(EpisodeVo vo) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.episodeInsert(conn, vo);
		
		if( result == 1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
	}

	public int getEpisodeCnt() throws Exception{
		Connection conn = getConnection();
		int cnt = dao.getEpisodeCnt(conn);
		
		close(conn);
		
		return cnt;
	}

}
