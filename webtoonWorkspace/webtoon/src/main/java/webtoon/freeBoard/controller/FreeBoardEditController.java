package webtoon.freeBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.freeBoard.service.FreeBoardService;
import webtoon.freeBoard.vo.FreeBoardVo;

@WebServlet("/board/freeBoard/edit")
public class FreeBoardEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");

			FreeBoardService bs = new FreeBoardService();
			boolean isSelf = true;
			FreeBoardVo vo = bs.getFreeBoardByNo(no, isSelf);

			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/freeBoard/edit.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			FreeBoardVo vo = new FreeBoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);

			FreeBoardService bs = new FreeBoardService();
			int result = bs.edit(vo);

			if (result != 1) {
				throw new Exception("게시글 수정 실패");
			}

			resp.sendRedirect("/webtoon/board/freeBoard/detail?no=" + no);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);

		}

	}

}
