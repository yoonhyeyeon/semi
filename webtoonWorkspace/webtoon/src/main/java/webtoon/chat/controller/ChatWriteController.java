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

@WebServlet("/chat/write")
public class ChatWriteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			String no = req.getParameter("no");
			String refEpisodeNo = req.getParameter("refEpisodeNo");
			String content = req.getParameter("content");
			String enrollDate = req.getParameter("enrollDate");
			
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String MemberNo = loginMemberVo.getNo();
			String nick = loginMemberVo.getNick();
			
			ChatVo vo = new ChatVo();
			vo.setNo(no);
			vo.setRefEpisodeNo(refEpisodeNo);
			vo.setContent(content);
			vo.setMemberNo(MemberNo);
			vo.setEnrollDate(enrollDate);
			vo.setNick(nick);
			
			ChatService cs = new ChatService();
			int result = cs.writeChat(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
//			resp.sendRedirect("/webtoon/details");
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}
