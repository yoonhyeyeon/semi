package webtoon.pay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oracle.jdbc.proxy.annotation.Pre;
import webtoon.member.vo.MemberVo;
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

	public int pay(Connection conn, MemberVo loginMembervo) throws Exception{
		
		//sql
		String sql = "UPDATE MEMBER SET MCOIN = ? ,PAY_TOTAL = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, loginMembervo.getMcoin());
		pstmt.setInt(2, loginMembervo.getPay_total());
		pstmt.setString(3, loginMembervo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public int payUpdate(Connection conn, MemberVo loginMembervo) throws Exception{
		
		String sql ="SELECT * FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMembervo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
		
				
	}

}
