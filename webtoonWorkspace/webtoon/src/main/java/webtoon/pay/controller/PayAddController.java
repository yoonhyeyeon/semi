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

@WebServlet("/pay/add")
public class PayAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			if(loginMemberVo == null) {
				throw new Exception("로그인 하고 오세요");
			}			
			req.getRequestDispatcher("/WEB-INF/views/pay/payAdd.jsp").forward(req, resp);			
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			String bank = req.getParameter("bank");
			String card1 = req.getParameter("cardNum1");
			String card2 = req.getParameter("cardNum2");
			String card3 = req.getParameter("cardNum3");
			String card4 = req.getParameter("lastNum");
			String pwd = req.getParameter("cardPwd");
			
			String str = card1 + card2 + card3 + card4;
			
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String memberNo = loginMemberVo.getNo();
			
			PayAddVo vo = new PayAddVo();
			vo.setBank(bank);
			vo.setCard_no(str);
			vo.setCard_pwd(pwd);
			vo.setMember_no(memberNo);
			
			System.out.println(bank);
			System.out.println(str);
			System.out.println(pwd);
			
			PayService ps = new PayService();
			int result = ps.payAdd(vo);
			
			if(result != 1) {
				throw new Exception ("카드 등록 실패");
			}
			session.setAttribute("alertMsg", "카드 등록 완료");
			resp.sendRedirect("/webtoon/myPage");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", "카드 등록 중 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}
