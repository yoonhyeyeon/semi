package webtoon.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import webtoon.chat.service.ChatService;
import webtoon.chat.vo.ChatVo;

@WebServlet("/chat/list")
public class ChatListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String refEpisodeNo = req.getParameter("refEpisodeNo");
			
			ChatService cs = new ChatService();
			List<ChatVo> voList = cs.chatList(refEpisodeNo);
			
			Gson gson = new Gson();
			String str = gson.toJson(voList);
			
			resp.setContentType("text/html; charset=UTP-8");
			PrintWriter out = resp.getWriter();
			out.write(str);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}
