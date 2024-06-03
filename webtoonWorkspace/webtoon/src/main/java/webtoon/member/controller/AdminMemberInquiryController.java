package webtoon.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.member.service.MemberService;
import webtoon.member.vo.MemberVo;

@WebServlet("/admin/memberInquiry")
public class AdminMemberInquiryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
        	MemberService memberService = new MemberService();
            List<MemberVo> members = memberService.getAllMembers(); // 변수 이름 변경 'member' -> 'members'
            req.setAttribute("members", members); // 변경: 'member' -> 'members'
            req.getRequestDispatcher("/WEB-INF/views/admin/adminMemberInquiry.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "회원 정보 검색 오류: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    
    }
}
