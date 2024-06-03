package webtoon.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webtoon.customer.vo.CustomerInquiryVo;

public class CustomerInquiryDao {
	public int insertInquiry(Connection conn, CustomerInquiryVo vo) throws SQLException {
	    String sql = "INSERT INTO CUSTOMER_INQUIRY (INQUIRY_NO, MEMBER_NO, TITLE, CONTENT, ENROLL_DATE) VALUES (SEQ_CUSTOMER_INQUIRY_NO.NEXTVAL, ?, ?, ?, SYSDATE)";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, vo.getMemberNo());
	        pstmt.setString(2, vo.getTitle());
	        pstmt.setString(3, vo.getContent());
	        return pstmt.executeUpdate();
	    }
	}
	
    public List<CustomerInquiryVo> getAllInquiries(Connection conn) throws SQLException {
        List<CustomerInquiryVo> inquiries = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMER_INQUIRY ORDER BY INQUIRY_NO DESC";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                CustomerInquiryVo vo = new CustomerInquiryVo();
                vo.setInquiryNo(rs.getString("INQUIRY_NO"));
                vo.setMemberNo(rs.getString("MEMBER_NO"));
                vo.setTitle(rs.getString("TITLE"));
                vo.setContent(rs.getString("CONTENT"));
                vo.setEnrollDate(rs.getString("ENROLL_DATE"));
                inquiries.add(vo);
            }
        }
        return inquiries;
    }
}