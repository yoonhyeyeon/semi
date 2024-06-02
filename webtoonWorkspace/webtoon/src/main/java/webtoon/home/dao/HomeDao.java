package webtoon.home.dao;

import static webtoon.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.home.vo.HomeVo;
import webtoon.home.vo.PageVo;
import webtoon.webtoon.vo.AttachmentVo;
import webtoon.webtoon.vo.CategoryVo;

public class HomeDao {

	public List<HomeVo> HomeList(Connection conn) throws Exception {
//		return ss.selectList("HomeMapper.home_list", pvo);
		String sql = "SELECT NO, NAME FROM WEBTOON";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<HomeVo> voList = new ArrayList<HomeVo>();
		
		while( rs.next() ) {
			String name = rs.getString("NAME");
			String no = rs.getNString("NO");
			
			HomeVo vo = new HomeVo();
			vo.setName(name);
			vo.setNo(no);
			
			voList.add(vo);
		}
		close(rs);
		close(pstmt);
		return voList;
		
	}

	public int getHomeCnt(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM WEBTOON WHERE DEL_YN = 'N'";
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

	public int HomeInsert(Connection conn, HomeVo vo) throws SQLException {
//		return ss.insert("HomeMapper.home_insert",vo);
		String sql = "INSERT INTO WEBTOON ( NO , GENRE_NO , NAME , DAY , PROFILE ) VALUES ( SEQ_WEBTOON_NO.NEXTVAL , ? , ? , ?, ? )"; 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getGenre_no());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getDay());
		pstmt.setString(4, vo.getProfile());
		
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

//	public int insertAttachment(SqlSession ss, List<AttachmentVo> voList) {
//		return ss.insert("HomeMapper.insertHomeAttachment", voList);
//		
//	}

	public List<CategoryVo> getCategoryVoList(Connection conn) throws Exception {
		String sql = "SELECT * FROM CATEGORY ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String name= rs.getString("NAME");
			
			CategoryVo vo = new CategoryVo();
			vo.setNo(no);
			vo.setName(name);
			categoryVoList.add(vo);
		}
		close(rs);
		close(pstmt);
		return categoryVoList;
		
		
	}

}
