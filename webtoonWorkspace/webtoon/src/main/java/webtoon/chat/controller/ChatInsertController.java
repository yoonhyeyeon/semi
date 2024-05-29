package webtoon.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.chat.service.ChatService;
import webtoon.chat.vo.ChatVo;
import webtoon.member.vo.MemberVo;

@WebServlet("/chat/insert")
public class ChatInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/chat/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			
			String content = req.getParameter("content");
			String ref_episode_no = req.getParameter("ref_episode_no");
			
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String member_no = loginMemberVo.getNo();
			
			ChatVo chatVo = new ChatVo();
			chatVo.setContent(content);
			chatVo.setRef_episode_no(ref_episode_no);
			chatVo.setMember_no(member_no);
			
			ChatService cs = new ChatService();
			int result = cs.insertChat(chatVo);
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}//class
