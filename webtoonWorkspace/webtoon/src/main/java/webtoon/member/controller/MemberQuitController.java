package webtoon.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.member.service.MemberService;
import webtoon.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String no = loginMemberVo.getNo();
			
			MemberService ms = new MemberService();
			int result = ms.quit(no);
			
			if(result != 1) {
				throw new Exception("회원 탈퇴 실패..");
			}
			session.removeAttribute("loginMemberVo");
			session.setAttribute("alertMsg", "회원탈퇴 성공!");
			resp.sendRedirect("/webtoon/home");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
