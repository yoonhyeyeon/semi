package webtoon.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.sql.INTERVALDS;
import webtoon.member.vo.MemberVo;
import webtoon.pay.service.PayService;
import webtoon.pay.vo.PayAddVo;
import webtoon.pay.vo.PayVo;

@WebServlet("/pay/payment2")
public class PaymentController2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			
			if(loginMemberVo == null) {
				throw new Exception("로그인 하고 오세요");
			}
			

			String coin = req.getParameter("coin");
			
			
			req.setAttribute("coin", coin);

			req.getRequestDispatcher("/WEB-INF/views/pay/payment2.jsp").forward(req, resp);
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
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");;
			

	
			String no = loginMemberVo.getNo();
			String nick = loginMemberVo.getNick();
			int mcoin = loginMemberVo.getMcoin();
			int pay_total = loginMemberVo.getPay_total();
			
			String coin1 = req.getParameter("coin");
			int coin = Integer.parseInt(coin1);
			int coinTotal = mcoin - coin;
			
			if(coinTotal < 10) {
				session.setAttribute("alertMsg", "코인이 부족합니다");
				resp.sendRedirect("/webtoon/myPage");
				return;
			}
			
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setMcoin(coinTotal);
			vo.setNick(nick);
			
			PayService ps = new PayService();
			int result = ps.pay(vo);
			int result2 = ps.payupdate(vo);
			
			if(result != 1) {
				throw new Exception("결제 오류입니다.");
			}
			if(result2 != 1) {
				throw new Exception("문코인 업데이트 오류입니다.");
			}
			

			session.setAttribute("loginMemberVo", vo);
			session.setAttribute("alertMsg", "결제완료!");
			resp.sendRedirect("/webtoon/myPage");
		

	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		req.setAttribute("errMsg", "결제 실패");
		req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
	}
		
	}
}

