package webtoon.episode.dao;

import static webtoon.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.episode.vo.EpisodeVo;
import webtoon.webtoon.vo.CategoryVo;

public class EpisodeDao {

	public List<EpisodeVo> EpisodeList(SqlSession ss) {
		return ss.selectList("EpisodeMapper.episode_list");
	}

	public int episodeInsert(Connection conn, EpisodeVo vo) throws Exception {
		
		String sql = "INSERT INTO WEBTOON_EPISODE (NO, WEBTOON_NAME, TITLE, WRITER) VALUES(SEQ_WEBTOON_EPISODE_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getWebtoonName());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getWriter());
		
		int result = pstmt.executeUpdate();
		
		close(conn);
		
		return result;
	}

	public List<CategoryVo> getCategoryVoList(Connection conn) throws Exception {
		String sql = "SELECT * FROM CATEGORY ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			
			CategoryVo vo = new CategoryVo();
			vo.setNo(no);
			vo.setName(name);
			categoryVoList.add(vo);
			
		}
		close(rs);
		close(pstmt);
		return categoryVoList;
		
	}

	public int getEpisodeCnt(Connection conn) throws Exception {
		String sql = "SELECT COUNT(*) FROM WEBTOON_EPISODE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		close(rs);
		close(pstmt);
		
		return cnt;
		
	}

}
