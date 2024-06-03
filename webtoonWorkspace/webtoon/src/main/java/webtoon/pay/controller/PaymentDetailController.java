package webtoon.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webtoon.member.vo.MemberVo;
import webtoon.pay.service.PayService;
import webtoon.pay.vo.PayVo;

@WebServlet("/pay/paymentDetail")
public class PaymentDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			PayVo payVo = (PayVo)session.getAttribute("payVo");
			
			if(loginMemberVo == null) {
				throw new Exception("로그인을 해주세요");
			}
			
			String no = loginMemberVo.getNo();
			
			PayVo pvo = new PayVo();
			pvo.setMember_no(no);
			
			PayService ps = new PayService();
			List<PayVo> payVoList = ps.payVoList(pvo);
			
			req.setAttribute("payVoList", payVoList);
			
			req.getRequestDispatcher("/WEB-INF/views/pay/paymentDetail.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
