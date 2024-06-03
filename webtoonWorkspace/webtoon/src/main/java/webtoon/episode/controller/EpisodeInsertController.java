package webtoon.episode.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import webtoon.episode.service.EpisodeService;
import webtoon.episode.vo.EpisodeVo;
import webtoon.webtoon.vo.CategoryVo;
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 500 ,
		fileSizeThreshold = 1024 * 1024 * 50
		)

@WebServlet("/episode/insert")
public class EpisodeInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.getRequestDispatcher("/WEB-INF/views/webtoon/episode_insert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			String no = req.getParameter("no");
			String webtoon_name = req.getParameter("webtoonName");
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String enroll_date = req.getParameter("enrollDate");
			Part profile = req.getPart("profile");
			
			String changeName = "";
			
			if( profile.getSize() > 0 ) {
				String orginFileName = profile.getSubmittedFileName();
				InputStream is = profile.getInputStream();
				
				String path = "D:\\dev\\webtoon\\webtoonWorkspace\\webtoon\\src\\main\\webapp\\resources\\uploadimg\\";
				String random = UUID.randomUUID().toString();
				String ext = orginFileName.substring(orginFileName.lastIndexOf("."));
				changeName = System.currentTimeMillis() + "_" + random + ext;
				FileOutputStream fos = new FileOutputStream(path + changeName);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while( (size=is.read(buf)) != -1 ) {
					fos.write(buf, 0, size);
				}
				is.close();
				fos.close();
			}
			
			EpisodeVo vo = new EpisodeVo();
			vo.setNo(no);
			vo.setWebtoonName(webtoon_name);
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setEnrollDate(enroll_date);
			vo.setProfile(changeName);
			
			EpisodeService es = new EpisodeService();
			int result = es.episodeInsert(vo);
			
			resp.sendRedirect("/webtoon/episode");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}//class
