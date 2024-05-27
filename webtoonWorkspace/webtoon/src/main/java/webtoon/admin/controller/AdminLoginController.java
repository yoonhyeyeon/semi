package webtoon.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.admin.dao.AdminDao;
import webtoon.admin.service.AdminService;
import webtoon.admin.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
	}
	
	//기능구현
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			AdminVo vo = new AdminVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			
			//서비스 
			AdminDao adminDao = new AdminDao();
			AdminService as = new AdminService(adminDao);
			AdminVo loginAdminVo = as.login(vo);
			
			//결과
	        if (loginAdminVo == null) {
	            req.setAttribute("alertMsg", "관리자 회원 로그인 실패...");
	            req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
	        } else {
	            HttpSession session = req.getSession();
	            session.setAttribute("alertMsg", "관리자 회원 로그인 성공!");
	            session.setAttribute("loginAdminVo", loginAdminVo);
	            resp.sendRedirect("/webtoon/home");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();

	    }
		
		
		
	}
	
	
	
	
	
	
	
	
}//class























