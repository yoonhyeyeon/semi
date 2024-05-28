package webtoon.freeBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.freeBoard.service.FreeBoardService;
import webtoon.freeBoard.vo.FreeBoardVo;
import webtoon.freeBoard.vo.PageVo;

@WebServlet("/board/freeBoard/list")
public class FreeBoardListController extends HttpServlet{

	private final FreeBoardService bs;
	public FreeBoardListController() {
		this.bs = new FreeBoardService();
	}
	
	// 게시글 목록
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int listCount = bs.getBoardCnt();
			String x = req.getParameter("pno") == null ? "1" : req.getParameter("pno");
			int currenPage = Integer.parseInt(x);
			int PageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currenPage, PageLimit, boardLimit);
			
			List<FreeBoardVo> voList = bs.selectFreeBoardList(pvo);
			
			req.setAttribute("voList", voList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/freeBoard/list.jsp").forward(req, resp);
		}catch(Exception e) {
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
