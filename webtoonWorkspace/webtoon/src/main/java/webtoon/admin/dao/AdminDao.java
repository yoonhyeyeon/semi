package webtoon.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webtoon.admin.vo.AdminVo;
import webtoon.db.JDBCTemplate;

public class AdminDao {

	public AdminVo login(Connection conn, AdminVo vo) throws Exception{
		String sql = "SELECT * FROM ADMIN WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		AdminVo loginAdminVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String pwd2 = rs.getString("PWD2");
			String nick = rs.getString("NICK");
			String del_yn = rs.getString("DEL_YN");
			
			loginAdminVo = new AdminVo();
			loginAdminVo.setNo(no);
			loginAdminVo.setId(id);
			loginAdminVo.setPwd(pwd);
			loginAdminVo.setPwd(pwd2);
			loginAdminVo.setNick(nick);
			loginAdminVo.setDel_yn(del_yn);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return loginAdminVo;
	}

	public int edit(Connection conn, AdminVo vo) throws SQLException {

		String sql = "UPDATE ADMIN SET NICK = ?, PWD = ? WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();
		
		return result;
		
		
		
	}

}















