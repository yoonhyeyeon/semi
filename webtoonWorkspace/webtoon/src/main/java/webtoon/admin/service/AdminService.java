package webtoon.admin.service;

import static webtoon.db.JDBCTemplate.close;
import static webtoon.db.JDBCTemplate.getConnection;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import webtoon.admin.dao.AdminDao;
import webtoon.admin.vo.AdminVo;
import webtoon.db.JDBCTemplate;
import webtoon.db.SqlSessionTemplate;
import webtoon.member.vo.MemberVo;

public class AdminService {

	private final AdminDao dao;
	
	public AdminService() {
		this.dao = new AdminDao();
	}
	
    public AdminVo login(AdminVo vo) throws Exception {
    	//비즈니스 로직
    	
    	//DAO 호출
    	Connection conn = getConnection();
		AdminVo loginAdminVo = dao.login(conn,vo);
		
		close(conn);
		
		return loginAdminVo;
    }

	public int edit(AdminVo vo) throws Exception{
		if(!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다");
		}
		
		//dao
		Connection conn =getConnection();
		int result = dao.edit(conn,vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

}


























