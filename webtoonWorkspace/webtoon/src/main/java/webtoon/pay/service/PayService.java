package webtoon.pay.service;


import static webtoon.db.JDBCTemplate.*;

import java.sql.Connection;

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

}
