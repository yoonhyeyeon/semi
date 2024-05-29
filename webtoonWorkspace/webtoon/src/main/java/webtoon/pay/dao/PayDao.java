package webtoon.pay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import webtoon.pay.vo.PayAddVo;
import static webtoon.db.JDBCTemplate.*;

public class PayDao {

	public int payAdd(Connection conn, PayAddVo vo) throws Exception{
		
		String sql ="INSERT INTO payment_method_add(NO,MEMBER_NO,BANK,CARD_NO,CARD_PWD) VALUES(SEQ_PAYMENT_METHOD_NO.NEXTVAL,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMember_no());
		pstmt.setString(2, vo.getBank());
		pstmt.setString(3, vo.getCard_no());
		pstmt.setString(4, vo.getCard_pwd());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
		
	}

}
