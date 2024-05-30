package webtoon.webtoon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.db.JDBCTemplate;
import webtoon.webtoon.vo.AttachmentVo;
import webtoon.webtoon.vo.CategoryVo;

public class WebtoonDao {
	
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
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return categoryVoList;
	}
	
	public int insertWebtoonAttachment(SqlSession ss, List<AttachmentVo> attVoList) throws Exception{
		return ss.insert("WebtoonMapper.insertWebtoonAttachment", attVoList);
	}
	
	public List<AttachmentVo> getAttachment(Connection conn, String no) throws Exception{
		
		//SQL
		String sql = "SELECT * FROM WEBTOON_ATTACHMENT WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		List<AttachmentVo> attVoList = new ArrayList<AttachmentVo>();
		while(rs.next()) {
			String originName = rs.getString("ORIGIN_NAME");
			String changeName = rs.getString("CHANGE_NAME");
			
			AttachmentVo attVo = new AttachmentVo();
			attVo.setChangeName(changeName);
			attVo.setOriginName(originName);
			
			attVoList.add(attVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return attVoList;
			
		
	}//METHOD


	
}//class


















