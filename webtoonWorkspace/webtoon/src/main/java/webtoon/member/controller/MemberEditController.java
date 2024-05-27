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

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			
			if(loginMemberVo == null) {
				throw new Exception("로그인 하고 오세요");
			}
			req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			String no = loginMemberVo.getNo();
			String id = req.getParameter("id");
			String nick = req.getParameter("nick");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String address = req.getParameter("address");
			
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setNick(nick);
			vo.setPwd(pwd2);
			vo.setPwd2(pwd2);
			vo.setAddress(address);
			
			MemberService ms = new MemberService();
			int result = ms.edit(vo);
			
			if(result != 1) {
				throw new Exception("회원정보 수정 실패...");
			}
			session.setAttribute("alertMsg", "회원정보 수정 완료!");
			session.removeAttribute("loginMemberVo");
			resp.sendRedirect("/webtoon/home");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", "회원정보 수정 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}
