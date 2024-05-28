package webtoon.notion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.notion.service.NotionService;
import webtoon.notion.vo.NotionVo;
import webtoon.notion.vo.PageVo;

@WebServlet("/board/notion/list")
public class NotionListController extends HttpServlet {

	private final NotionService ns;

	public NotionListController() {
		this.ns = new NotionService();
	}

	// 게시글 목록
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int listCount = ns.getNotionCnt();
			String x = req.getParameter("pno") == null ? "1" : req.getParameter("pno");
			int currentPage = Integer.parseInt(x);
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			List<NotionVo> voList = ns.getNotionList(pvo);

			req.setAttribute("voList", voList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/board/notionList.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
