package webtoon.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.member.service.MemberService;

@WebServlet("/member/idCheck")
public class MemberIdDupCheckController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id =req.getParameter("id");
			
			MemberService ms = new MemberService();
			boolean isAvailable = ms.idCheck(id);
			
			if(!isAvailable) {
				throw new Exception("중복검사 실패..");
			}
			resp.getWriter().write("can");
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().write("cant");
		}
	}
		

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
