package webtoon.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import webtoon.home.service.HomeService;
import webtoon.home.vo.HomeVo;
import webtoon.home.vo.PageVo;

@WebServlet("/home")
public class HomeListController extends HttpServlet{

	private final HomeService hs;
	public HomeListController() {
		this.hs = new HomeService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<HomeVo> voList = hs.HomeList();
			
			req.setAttribute("voList", voList);
			
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
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
