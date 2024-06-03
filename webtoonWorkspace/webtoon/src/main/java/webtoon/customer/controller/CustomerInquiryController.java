package webtoon.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.customer.service.CustomerInquiryService;
import webtoon.customer.vo.CustomerInquiryVo;
import webtoon.member.vo.MemberVo;

@WebServlet("/customer/inquiry")
public class CustomerInquiryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            resp.sendRedirect(req.getContextPath() + "/member/login");
            return;
        }

        String inquiryNo = req.getParameter("inquiryNo");
        String memberNo = String.valueOf(loginMemberVo.getNo());
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String enrollDate = req.getParameter("enrollDate");

        CustomerInquiryVo vo = new CustomerInquiryVo(inquiryNo, memberNo, title, content, enrollDate);

        CustomerInquiryService service = new CustomerInquiryService();
        try {
            boolean result = service.insertInquiry(vo);
            if (result) {
                session.setAttribute("alertMsg", "문의가 정상적으로 등록되었습니다.");
                resp.sendRedirect(req.getContextPath() + "/customer/home");
            } else {
                throw new Exception("문의 등록 실패");
            }
        } catch (Exception e) {
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
}