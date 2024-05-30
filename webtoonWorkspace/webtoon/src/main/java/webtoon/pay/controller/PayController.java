package webtoon.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import webtoon.member.vo.MemberVo;
import webtoon.pay.service.PayService;

@WebServlet("/pay")
public class PayController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			
			if(loginMemberVo == null) {
				throw new Exception("로그인 하고 오세요");
			}
			req.getRequestDispatcher("/WEB-INF/views/pay/pay.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			String no = loginMemberVo.getNo();
			int mcoin = loginMemberVo.getMcoin();
			
			String coin1 = req.getParameter("coin");
			int coin = Integer.parseInt(coin1);
			
			
			
			int totalCoin = mcoin + coin;
			
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setMcoin(totalCoin);
			
			PayService ps = new PayService();
			int result = ps.pay(vo);
			int result2 = ps.payupdate(vo);
			
			if(result != 1) {
				throw new Exception("결제 오류입니다.");
			}
			if(result2 != 1) {
				throw new Exception("문코인 업데이트 오류입니다.");
			}
			session.setAttribute("alertMsg", "결제완료!");
			session.setAttribute("loginMemberVo", vo);
			resp.sendRedirect("/webtoon/myPage");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", "결제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}
