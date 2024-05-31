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

@WebServlet("/chat/list")
public class ChatController extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	
	public ChatController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTP-8");
		
		resp.setContentType("text/html; charset-=UTP-8");
		PrintWriter out = resp.getWriter();
		
		int exe = Integer.parseInt(req.getParameter("exe"));
		String no = req.getParameter("no");
		String refEpisodeNo = req.getParameter("refEpisodeNo");
		String content = req.getParameter("content");
		String hit = req.getParameter("hit");
		String enrollDate = req.getParameter("enrollDate");
		
		MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
		String memberNo = loginMemberVo.getNo();
		
		int currentPage = Integer.parseInt(req.getParameter("page"));
		ChatVo vo = new ChatVo();
		vo.setNo(no);
		vo.setRefEpisodeNo(refEpisodeNo);
		vo.setContent(content);
		vo.setHit(hit);
		vo.setEnrollDate(enrollDate);
		vo.setMemberNo(memberNo);
		
		
		ChatService cs = ChatService.getInstance();
		
		try {
			out.print("<script>");
			if( exe == 1 ) {
				cs.insert(vo);
			}else if ( exe == 2) {
				boolean res = cs.update(vo);
				if( res ) {
					out.print("alert('댓글 수정 완료');");
				}else {
					out.print("alert('댓글 수정 실패');");
				}
			}else {
				boolean res = cs.delete(refEpisodeNo, memberNo);
				if( res ) {
					out.print("alert('댓글 삭제 완료')");
				}else {
					out.print("alert('댓글 삭제 실패');");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("");
		
	}
	
}
