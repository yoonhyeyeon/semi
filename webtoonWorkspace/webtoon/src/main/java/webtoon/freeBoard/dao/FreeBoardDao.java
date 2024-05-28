package webtoon.freeBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import static webtoon.db.JDBCTemplate.*;

import webtoon.freeBoard.vo.FreeBoardVo;
import webtoon.freeBoard.vo.PageVo;

public class FreeBoardDao {

	// 게시글 작성
	public int insert(SqlSession ss, FreeBoardVo vo) {
		return ss.insert("FreeBoardMapper.freeBoard_insert", vo);
	}

	// 게시글 목록 조회
	public List<FreeBoardVo> selectFreeBoardList(SqlSession ss, PageVo pvo) {
		
		return ss.selectList("FreeBoardMapper.freeBoard_list", pvo);
		
	}

	public int getFreeBoardCnt(Connection conn) throws Exception {
		
//		return ss.selectOne("FreeBoardMapper.freeBoard_cnt");
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if( rs.next() ) {
			cnt = rs.getInt(1);
		}
		
		close(rs);
		close(pstmt);
		
		return cnt;
		
	}

	public FreeBoardVo getFreeBoardByNo(SqlSession ss, String no) {
		
		return ss.selectOne("FreeBoardMapper.freeBoard_datail", no);
		
	}

	public int increaseHit(SqlSession ss, String no) {
		return ss.update("FreeBoardMapper.freeBoard_hit",no);
	}

	public int edit(SqlSession ss, FreeBoardVo vo) {
		return ss.update("FreeBoardMapper.freeBoard_edit", vo);
		
	}

	public int delete(SqlSession ss, FreeBoardVo boardVo) {
		return ss.update("FreeBoardMapper.freeBoard_delete", boardVo);
		
	}

	
	
}//class
