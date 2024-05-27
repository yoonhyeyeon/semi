package webtoon.notion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.admin.vo.AdminVo;
import webtoon.notion.service.NotionService;
import webtoon.notion.vo.NotionVo;

@WebServlet("/board/notion/delete")
public class NotionDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();

			String no = req.getParameter("no");
			String adminVo = ((AdminVo) session.getAttribute("loginAdminVo")).getNo();

			NotionVo notionVo = new NotionVo();
			notionVo.setNo(no);
			notionVo.setWriter_no(adminVo);

			NotionService ns = new NotionService();
			int result = ns.delete(notionVo);

			if (result != 1) {
				throw new Exception("게시글 삭제 실패");
			}

			session.setAttribute("alertMsg", "게시글 삭제 성공");
			resp.sendRedirect("/webtoon/board/notion/list");
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
