package webtoon.pay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import oracle.jdbc.proxy.annotation.Pre;
import webtoon.member.vo.MemberVo;
import webtoon.pay.vo.PayAddVo;
import webtoon.pay.vo.PayVo;

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
	
	
	
	public int getPayment(Connection conn, MemberVo loginMembervo,PayAddVo payAddVo,PayVo pvo) throws Exception{
		
		String sql ="INSERT INTO PAYMENT(NO,MEMBER_NO,PAYMENT_METHOD_NO,PAY) VALUES(SEQ_PAYMENT_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMembervo.getNo());
		pstmt.setString(2, payAddVo.getNo());
		pstmt.setInt(3, pvo.getPay());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}
	public PayAddVo selectPayAdd(Connection conn, PayAddVo vo) throws Exception{
		String sql = "SELECT * FROM PAYMENT_METHOD_ADD WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMember_no());
		ResultSet rs = pstmt.executeQuery();
		
		PayAddVo payAddVo = null;
		
		if(rs.next()) {
			String no = rs.getString("NO");
			String member_no = rs.getString("MEMBER_NO");
			String bank = rs.getString("BANK");
			String card_no = rs.getString("CARD_NO");
			String card_pwd = rs.getString("CARD_PWD");
			String enroll_date = rs.getString("ENROLL_DATE");
			String del_yn = rs.getString("DEL_YN");
			
			payAddVo = new PayAddVo();
			payAddVo.setNo(no);
			payAddVo.setMember_no(member_no);
			payAddVo.setBank(bank);
			payAddVo.setCard_no(card_no);
			payAddVo.setCard_pwd(card_pwd);
			payAddVo.setEnroll_date(enroll_date);
			payAddVo.setDel_yn(del_yn);
		}
		close(rs);
		close(pstmt);
		
		return payAddVo;
	}

	public List<PayVo> payVoList(Connection conn,PayVo vo) throws Exception{
		String sql ="SELECT * FROM PAYMENT WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		
			List<PayVo> pvoList = new ArrayList<PayVo>();
			
			while(rs.next()) {
			String no = rs.getString("no");
			int pay = rs.getInt("pay");
			String enroll_date = rs.getString("ENROLL_DATE");
			
			PayVo pvo = new PayVo();
			pvo.setNo(no);
			pvo.setPay(pay);
			pvo.setEnroll_date(enroll_date);
			
			
			pvoList.add(pvo);
			
		}
		close(rs);
		close(pstmt);
		
		return pvoList;
	}
	
	
	
}

