package webtoon.customer.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webtoon.customer.service.CustomerInquiryService;
import webtoon.customer.vo.CustomerInquiryVo;

@WebServlet("/admin/look")
public class AdminInquiryListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerInquiryService service = new CustomerInquiryService();
        try {
            List<CustomerInquiryVo> inquiries = service.getAllInquiries();
            req.setAttribute("inquiries", inquiries);
            req.getRequestDispatcher("/WEB-INF/views/admin/inquiriesList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/member/login");
        }
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	}
}
