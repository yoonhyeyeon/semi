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
import webtoon.member.vo.MemberVo;

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
			//세션
			HttpSession session = req.getSession();
			
			//데이터 꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			AdminVo vo = new AdminVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			AdminService as = new AdminService();
			AdminVo loginAdminVo = as.login(vo);
			
			if(loginAdminVo != null) {
				session.setAttribute("alertMsg", "관리자 로그인 성공!!");
				session.setAttribute("loginAdminVo", loginAdminVo);
				System.out.println("로그인 성공");
			}else {
				session.setAttribute("alertMsg", "관리자 로그인 실패...");
				System.out.println("로그인 실패: ID 또는 비밀번호 불일치 또는 계정이 삭제됨");
			}
			resp.sendRedirect("/webtoon/home");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-M0002] 로그인 중 에러 발생 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

		
	}
	
	
	
	
	
	
	
	
}//class























