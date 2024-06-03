package webtoon.pay.service;


import static webtoon.db.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import webtoon.member.vo.MemberVo;
import webtoon.pay.dao.PayDao;
import webtoon.pay.vo.PayAddVo;
import webtoon.pay.vo.PayVo;
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
	public int getPayment(MemberVo loginMembervo,PayAddVo payAddVo,PayVo pvo) throws Exception{
		
		
		//dao
		Connection conn =getConnection();
		int result = dao.getPayment(conn, loginMembervo, payAddVo,pvo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public PayAddVo selectPayAdd(PayAddVo vo) throws Exception{
		Connection conn = getConnection();
		PayAddVo payAddVo = dao.selectPayAdd(conn, vo);
		
		close(conn);
		
		return payAddVo;
	}

	public List<PayVo> payVoList(PayVo vo) throws Exception{
		
		//dao
		Connection conn = getConnection();
		List<PayVo> pvoList = dao.payVoList(conn, vo);
		
		close(conn);
		
		return pvoList;
	}


}
