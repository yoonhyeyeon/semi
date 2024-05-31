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

	public List<AttachmentVo> getAllAttachments(Connection conn) throws SQLException {
	    List<AttachmentVo> attachments = new ArrayList<>();
	    // 'attachment' 대신 'WEBTOON_ATTACHMENT' 테이블을 참조해야 합니다.
	    String sql = "SELECT * FROM WEBTOON_ATTACHMENT";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
	    
	    while (rs.next()) {
	        AttachmentVo vo = new AttachmentVo();
	        // 각 컬럼에 맞는 데이터를 설정합니다.
	        vo.setOriginName(rs.getString("origin_name"));
	        vo.setChangeName(rs.getString("change_name"));
	        // 추가적인 필드에 대한 설정이 필요할 수 있습니다.
	        attachments.add(vo);
	    }
	    rs.close();
	    pstmt.close();

	    return attachments;
	}


	
}//class


















