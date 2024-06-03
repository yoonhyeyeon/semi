package webtoon.customer.service;

import java.sql.Connection;
import java.util.List;

import webtoon.customer.dao.CustomerInquiryDao;
import webtoon.customer.vo.CustomerInquiryVo;
import webtoon.db.JDBCTemplate;

public class CustomerInquiryService {
    private final CustomerInquiryDao dao;

    public CustomerInquiryService() {
        this.dao = new CustomerInquiryDao();
    }

    public boolean insertInquiry(CustomerInquiryVo vo) throws Exception {
        try (Connection conn = JDBCTemplate.getConnection()) {
            int result = dao.insertInquiry(conn, vo);
            if (result > 0) {
                JDBCTemplate.commit(conn);
                return true;
            } else {
                JDBCTemplate.rollback(conn);
                return false;
            }
        }
    }
    
    public List<CustomerInquiryVo> getAllInquiries() throws Exception {
        try (Connection conn = JDBCTemplate.getConnection()) {
            return dao.getAllInquiries(conn);
        }
    }
    
}