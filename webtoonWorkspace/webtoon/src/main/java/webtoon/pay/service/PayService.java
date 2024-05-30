package webtoon.pay.service;


import static webtoon.db.JDBCTemplate.*;

import java.sql.Connection;

import webtoon.member.vo.MemberVo;
import webtoon.pay.dao.PayDao;
import webtoon.pay.vo.PayAddVo;
public class PayService {

	private PayDao dao;
	
	public PayService() {
		dao = new PayDao();
	}
	
	public int payAdd(PayAddVo vo) throws Exception{
		
		
		//DAO
		Connection conn = getConnection();
		int result = dao.payAdd(conn,vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int pay(MemberVo loginMembervo) throws Exception{
		
		
		//dao
		Connection conn = getConnection();
		int result = dao.pay(conn,loginMembervo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int payupdate(MemberVo logMemberVo) throws Exception{
		
		
		//dao
		Connection conn =getConnection();
		int result = dao.payUpdate(conn, logMemberVo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
