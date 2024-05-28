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
import webtoon.member.vo.MemberVo;

@WebServlet("/board/freeBoard/delete")
public class FreeBoardDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();

			String no = req.getParameter("no");
			String member_no = ((MemberVo) session.getAttribute("loginMemberVo")).getNo();

			FreeBoardVo boardVo = new FreeBoardVo();
			boardVo.setNo(no);
			boardVo.setWriter_no(member_no);

			FreeBoardService bs = new FreeBoardService();
			int result = bs.delete(boardVo);

			if (result != 1) {
				throw new Exception("게시글 삭제 실패");
			}

			session.setAttribute("alertMsg", "게시글 삭제 성공");
			resp.sendRedirect("/webtoon/board/freeBoard/list");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
