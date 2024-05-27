package webtoon.notion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.notion.service.NotionService;
import webtoon.notion.vo.NotionVo;

@WebServlet("/board/notion/edit")
public class NotionEditController extends HttpServlet {

	// 수정화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");

			NotionService ns = new NotionService();
			NotionVo vo = ns.getNotionByNo(no);

			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/notionEdit.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	// 수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			NotionVo vo = new NotionVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);

			NotionService ns = new NotionService();
			int result = ns.edit(vo);
			if (result != 1) {
				throw new Exception("게시글 수정 실패...");
			}

			resp.sendRedirect("/webtoon/board/notion/detail?no=" + no);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
