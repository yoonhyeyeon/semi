package webtoon.episode.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.episode.service.EpisodeService;
import webtoon.episode.vo.EpisodeVo;

@WebServlet("/episode")
public class EpisodeListController extends HttpServlet{

	private final EpisodeService es;
	
	public EpisodeListController() {
		this.es = new EpisodeService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
//			int listCount = es.getEpisodeCnt();
//			String x = req.getParameter("pno") == null ? "1" : req.getParameter("pno");
//			int currenPage = Integer.parseInt(x);
			
			List<EpisodeVo> voList = es.EpisodeList();
			
			req.setAttribute("voList", voList);
			
			System.out.println(voList);
			req.getRequestDispatcher("/WEB-INF/views/webtoon/episode.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
}
