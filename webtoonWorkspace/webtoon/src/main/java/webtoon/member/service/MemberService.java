package webtoon.member.service;

import static webtoon.db.JDBCTemplate.close;
import static webtoon.db.JDBCTemplate.commit;
import static webtoon.db.JDBCTemplate.getConnection;
import static webtoon.db.JDBCTemplate.rollback;

import java.sql.Connection;

import webtoon.member.dao.MemberDao;
import webtoon.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao dao;
	
	public MemberService() {
		this.dao = new MemberDao();
	}
	

	public int memberJoin(MemberVo vo) throws Exception{
		//비즈니스로직
		
		//아이디 유효성 검사
		if(vo.getId().length() >= 16 || vo.getId().length() <= 4) {
			throw new Exception("아이디를 4~16자 이내로 작성해주세요");
		}
		
		
		//비밀번호 일치 여부
		try {
			if(!vo.getPwd().equals(vo.getPwd2())) {
				throw new Exception("비밀번호가 일치하지 않습니다.");
			}
			
		}catch(NullPointerException e) {
			System.out.println("아이디 또는 비밀번호가 없습니다");
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
		
		
		//Dao
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


	public boolean idCheck(String id) throws Exception{
		
		//DAO 호출
		Connection conn = getConnection();
		int result = dao.idCheck(conn,id);
				
		close(conn);
		
		return result == 0;
	}
	
}