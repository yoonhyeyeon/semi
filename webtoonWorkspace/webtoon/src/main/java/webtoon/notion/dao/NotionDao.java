package webtoon.notion.dao;

import static webtoon.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import webtoon.notion.vo.NotionVo;
import webtoon.notion.vo.PageVo;

public class NotionDao {

	// 게시글 작성
	public int NotionInsert(SqlSession ss, NotionVo vo) throws Exception {
		return ss.insert("BoardMapper.notion_insert", vo);

//		String sql = "INSERT INTO NOTION (NO, WRITER_NO, TITLE, CONTENT, ENROLL_DATE, DEL_YN) VALUES (SEQ_NOTION_NO.NEXTVAL, ?, ?, ?, SYSDATE, 'N')";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getWriter_no());
//		pstmt.setString(1, vo.getTitle());
//		pstmt.setString(2, vo.getContent());
//		
//		int result = pstmt.executeUpdate();
//		
//		close(pstmt);
//		
//		return result;
	}

	// 게시글 목록 조회
	public List<NotionVo> getNotionList(SqlSession ss, PageVo pvo) throws Exception {
		return ss.selectList("BoardMapper.notion_list", pvo);

//		String sql = "SELECT * FROM( SELECT ROWNUM AS RNUM , T.* FROM( SELECT * FROM NOTION N JOIN ADMIN A ON N.WRITER_NO = A.NO WHERE N.DEL_YN = 'N' ORDER BY N.NO DESC )T ) WHERE RNUM BETWEEN ? AND ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, pvo.getStartNum());
//		pstmt.setInt(2, pvo.getEndNum());
//		ResultSet rs = pstmt.executeQuery();
//		
//		List<NotionVo> voList = new ArrayList<NotionVo>();
//		while( rs.next() ) {
//			String no = rs.getString("NO");
////			String writer_no = rs.getString("WRITER_NO");
//			String writer_no = rs.getString("NICK");
//			String title = rs.getString("TITLE");
//			String content = rs.getString("ENROLL_DATE");
//			String enroll_date = rs.getString("ENROLL_DATE");
//			String modify_date = rs.getNString("MODIFY_DATE");
//			String del_yn = rs.getString("DEL_YN");
//			
//			
//			NotionVo vo = new NotionVo();
//			vo.setNo(no);
////			vo.setWriter_no(writer_no);
//			vo.setNick(writer_no);
//			vo.setTitle(title);
//			vo.setContent(content);
//			vo.setEnroll_date(enroll_date);
//			vo.setModify_date(modify_date);
//			vo.setDel_yn(del_yn);
//			
//			voList.add(vo);
//		}
//		
//		close(pstmt);
//		close(rs);
//		return voList;

	}

	public int getNotionCnt(Connection conn) throws Exception {

		String sql = "SELECT COUNT(*) FROM NOTION WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		close(rs);
		close(pstmt);

		return cnt;
	}

	// 게시글 상세조회
	public NotionVo getNotionByNo(SqlSession ss, String no) throws Exception {

		return ss.selectOne("BoardMapper.notion_detail", no);

//		String sql = "SELECT N.NO ,N.TITLE ,N.CONTENT ,A.NICK ,N.ENROLL_DATE FROM NOTION N JOIN ADMIN A ON N.WRITER_NO = A.NO WHERE N.NO = ? AND N.DEL_YN = 'N'";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, no);
//		ResultSet rs = pstmt.executeQuery();
//		
//		NotionVo vo = null;
//		if( rs.next() ) {
////			String no = rs.getString("NO");
//			String title = rs.getString("TITLE");
//			String content = rs.getString("CONTENT");
//			String enroll_date = rs.getString("ENROLL_DATE");
//			String nick = rs.getString("NICK");
//			
//			vo = new NotionVo();
//			vo.setNo(no);
//			vo.setTitle(title);
//			vo.setContent(content);
//			vo.setEnroll_date(enroll_date);
//			vo.setNick(nick);
//		}
//		
//		close(conn);
//		close(pstmt);
//		return vo;

	}

	// 게시글 수정
	public int edit(SqlSession ss, NotionVo vo) throws Exception {

		return ss.update("BoardMapper.notion_edit", vo);

//		String sql = "UPDATE NOTION SET TITLE = ? , CONTENT = ? WHERE NO = ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getTitle());
//		pstmt.setString(2, vo.getContent());
//		pstmt.setString(3, vo.getNo());
//		
//		int result = pstmt.executeUpdate();
//		
//		close(pstmt);
//		
//		return result;
	}

	// 게시글 삭제
	public int delete(SqlSession ss, NotionVo notionVo) throws Exception {

		return ss.update("BoardMapper.notion_delete", notionVo);

//		String sql = "UPDATE NOTION SET DEL_YN = 'Y' WHERE NO = ? AND WRITER_NO = ? AND DEL_YN = 'N'";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, notionVo.getNo());
//		pstmt.setString(2, notionVo.getWriter_no());
//		
//		int result = pstmt.executeUpdate();
//		
//		close(pstmt);
//		
//		return result;

	}

}// class
