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
			String refEpisodeNo = req.getParameter("refEpisodeNo");
			String content = req.getParameter("content");
			
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String MemberNo = loginMemberVo.getNo();
			
			ChatVo vo = new ChatVo();
			vo.setRefEpisodeNo(refEpisodeNo);
			vo.setContent(content);
			vo.setMemberNo(MemberNo);
			
			ChatService cs = new ChatService();
			int result = cs.writeChat(vo);
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}
