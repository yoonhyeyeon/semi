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

@WebServlet("/board/notion/insert")
public class NotionInsertController extends HttpServlet {

	// 게시글 작성화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/board/notionInsert.jsp").forward(req, resp);
		
	}
	
	// 게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			AdminVo loginAdminVo = (AdminVo)session.getAttribute("loginAdminVo");
			String writer_no = loginAdminVo.getNo();
			
			NotionVo vo = new NotionVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter_no(writer_no);

			NotionService ns = new NotionService();
			int result = ns.NotionInsert(vo);
			
			if (result != 1) {
				throw new Exception("게시글 작성 실패 ..");
			}
			resp.sendRedirect("/webtoon/board/notion/list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMSg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);

		}

	}

}// class
