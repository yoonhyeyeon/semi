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
		String sql = "SELECT * FROM WEBTOON";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<HomeVo> voList = new ArrayList<HomeVo>();
		
		while( rs.next() ) {
			String no = rs.getNString("NO");
			String name = rs.getString("NAME");
			String genre_no = rs.getString("GENRE_NO");
			String day = rs.getString("DAY");
			String hit = rs.getString("HIT");
			String great = rs.getString("GREAT");
			String enroll_date = rs.getString("ENROLL_DATE");
			String modify_date = rs.getString("MODIFY_DATE");
			String del_yn = rs.getString("DEL_YN");
			String profile = rs.getString("PROFILE");
			
			
			HomeVo vo = new HomeVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setGenre_no(genre_no);
			vo.setDay(day);
			vo.setHit(hit);
			vo.setGreat(great);
			vo.setEnrollDate(enroll_date);
			vo.setModifyDate(modify_date);
			vo.setDelYn(del_yn);
			vo.setProfile(profile);
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

}
