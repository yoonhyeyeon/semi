package webtoon.episode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.episode.service.EpisodeService;
import webtoon.episode.vo.EpisodeVo;

@WebServlet("/details")
public class EpisodeDetailcontroller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			String webtoon_name = req.getParameter("webtoon_name");
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			
			EpisodeService es = new EpisodeService();
			EpisodeVo vo = es.getEpisodeByNo(no);
			
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/webtoon/details.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
