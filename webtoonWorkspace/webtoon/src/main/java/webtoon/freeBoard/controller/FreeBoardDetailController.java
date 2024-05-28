package webtoon.freeBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.freeBoard.service.FreeBoardService;
import webtoon.freeBoard.vo.FreeBoardVo;
import webtoon.member.vo.MemberVo;

@WebServlet("/board/freeBoard/detail")
public class FreeBoardDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");
			String writer_no = req.getParameter("writer_no");
			if (no == null || no.length() == 0) {
				throw new Exception("조회할 게시글 번호를 입력해주세요");
			}

			FreeBoardService bs = new FreeBoardService();
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
			boolean isSelf = loginMemberVo == null ? false : loginMemberVo.getNo().equals(writer_no);
			FreeBoardVo vo = bs.getFreeBoardByNo(no , isSelf);

			if (vo == null) {
				throw new Exception("게시글 조회 실패");
			}

			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/freeBoard/detail.jsp").forward(req, resp);

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
