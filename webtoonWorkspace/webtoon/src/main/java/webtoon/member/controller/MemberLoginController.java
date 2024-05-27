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

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//세션
			HttpSession session = req.getSession();
			
			//데이터 꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			MemberService ms = new MemberService();
			MemberVo loginMemberVo = ms.login(vo);
		
			
			if(loginMemberVo != null) {
				session.setAttribute("alertMsg", "로그인 성공!!");	
				session.setAttribute("loginMemberVo", loginMemberVo);
				
			}else {	
				session.setAttribute("alertMsg", "로그인 실패 ...");				
			}
			//req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
			resp.sendRedirect("/webtoon/home");
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-M0002] 로그인 중 에러 발생 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
	
}
