package webtoon.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.admin.service.AdminService;
import webtoon.admin.vo.AdminVo;
import webtoon.member.service.MemberService;
import webtoon.member.vo.MemberVo;

@WebServlet("/admin/edit")
public class AdminEditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			AdminVo loginAdminVo = (AdminVo)session.getAttribute("loginAdminVo");
		
			if(loginAdminVo == null) {
				throw new Exception("관리자 로그인 후 이용해주세요.");
			}
			req.getRequestDispatcher("/WEB-INF/views/admin/edit.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			AdminVo loginAdminVo = (AdminVo)session.getAttribute("loginAdminVo");
			String no = loginAdminVo.getNo();
			String id = req.getParameter("id");
			String nick = req.getParameter("nick");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			
			AdminVo vo = new AdminVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setNick(nick);
			vo.setPwd(pwd);
			vo.setPwd2(pwd2);

			AdminService ms = new AdminService();
			int result = ms.edit(vo);
			
			if(result != 1) {
				throw new Exception("관리자정보 수정 실패...");
			}
			session.setAttribute("alertMsg", "관리자정보 수정 완료!");
			session.removeAttribute("loginAdminVo");
			resp.sendRedirect("/webtoon/home");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", "관리자정보 수정 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
}



















