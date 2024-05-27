package webtoon.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.member.service.MemberService;
import webtoon.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String nick = req.getParameter("nick");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setPwd2(pwd2);
			vo.setNick(nick);
			vo.setAddress(address);
			vo.setPhone(phone);
			
			
			MemberService ms = new MemberService();
			int result = ms.memberJoin(vo);
			
			if(result ==1 ) {
				req.setAttribute("resultMsg", "회원가입 성공");
			}else {
				req.setAttribute("resultMsg", "회원가입 실패...");
			}
			resp.sendRedirect("/webtoon/member/login");
			
		}catch(Exception e){
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
				
	
	}
	
	
}
