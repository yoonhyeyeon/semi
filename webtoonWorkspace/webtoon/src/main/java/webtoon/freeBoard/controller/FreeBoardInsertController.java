package webtoon.freeBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.freeBoard.service.FreeBoardService;
import webtoon.freeBoard.vo.FreeBoardVo;

@WebServlet("/board/freeBoard/insert")
public class FreeBoardInsertController extends HttpServlet{


	// 게시글 작성화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/freeBoard/insert.jsp").forward(req, resp);
		
	}
	
	// 게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
//			String writer_no = req.getParameter("writer_no");

//			MemberVo loginMemberVo = (Membervo)session.getAttribute("loginMemberVo");
//			String writerNo = loginMemberVo.getNo();
			
			FreeBoardVo vo = new FreeBoardVo();
			vo.setTitle(title);
			vo.setContent(content);
//			vo.setWriter_no(writer_no);

			FreeBoardService bs = new FreeBoardService();
			int result = bs.FreeBoardInsert(vo);
			
			if (result != 1) {
				throw new Exception("게시글 작성 실패 ..");
			}
			resp.sendRedirect("/webtoon/board/freeBoard/list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMSg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);

		}

	}

	
}
