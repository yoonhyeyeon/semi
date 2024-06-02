package webtoon.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.member.vo.MemberVo;
import webtoon.pay.service.PayService;
import webtoon.pay.vo.PayAddVo;

@WebServlet("/pay/cardDetail")
public class CardDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			if(loginMemberVo == null) {
				throw new Exception("로그인 하고 오세요");
			}
			
			String memberNo = loginMemberVo.getNo();
			
			PayAddVo vo = new PayAddVo();
			vo.setMember_no(memberNo);
			
			PayService ps = new PayService();
			PayAddVo payAddVo = ps.selectPayAdd(vo);
			
			if(payAddVo != null) {
				session.setAttribute("payAddVo", payAddVo);
			}
			req.getRequestDispatcher("/WEB-INF/views/pay/cardDetail.jsp").forward(req, resp);
			resp.sendRedirect("/webtoon/myPage");
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
