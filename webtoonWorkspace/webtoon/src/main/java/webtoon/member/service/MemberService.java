package webtoon.member.service;

import static webtoon.db.JDBCTemplate.close;
import static webtoon.db.JDBCTemplate.commit;
import static webtoon.db.JDBCTemplate.getConnection;
import static webtoon.db.JDBCTemplate.rollback;

import java.sql.Connection;

import webtoon.member.dao.MemberDao;
import webtoon.member.vo.MemberVo;

public class MemberService {
	
	private MemberDao dao;
	
	public MemberService() {
		this.dao = new MemberDao();
	}
	

	public int memberJoin(MemberVo vo) throws Exception{
		//비즈니스로직
		
		//비밀번호 일치 여부
		try {
			if(!vo.getPwd().equals(vo.getPwd2())) {
				throw new Exception("비밀번호가 일치하지 않습니다.");
			}
			
		}catch(NullPointerException e) {
			System.out.println("비밀번호가 없습니다");
		}
		
		//DAO
		Connection conn = getConnection();
		int result = dao.memberJoin(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public MemberVo login(MemberVo vo) throws Exception{
		Connection conn = getConnection();
		MemberVo loginMemberVo = dao.login(conn,vo);
		
		close(conn);
		
		return loginMemberVo;
	}


	public int quit(String no) throws Exception{
		
		
		//DAO
		Connection conn = getConnection();
		int result = dao.quit(conn, no);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}


	public int edit(MemberVo vo) throws Exception{
		//비즈니스로직
		if(!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다");
		}
		
		//dao
		Connection conn =getConnection();
		int result = dao.edit(conn,vo);
		
		if(result ==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
}