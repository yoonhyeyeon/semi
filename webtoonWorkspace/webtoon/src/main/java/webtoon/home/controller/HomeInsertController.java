package webtoon.home.controller;

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

import webtoon.home.service.HomeService;
import webtoon.home.vo.HomeVo;
import webtoon.webtoon.vo.CategoryVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 500 ,
		fileSizeThreshold = 1024 * 1024 * 50
		)


@WebServlet("/home/insert")
public class HomeInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try{
			HomeService hs = new HomeService();
			List<CategoryVo> categoryVoList = hs.getCategoryVoList();
			
			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/webtoon/home_insert.jsp").forward(req, resp);
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
			
			String no = req.getParameter("no");
			String genreNo = req.getParameter("genre_no");
			String name = req.getParameter("name");
			String day = req.getParameter("day");
			String hit = req.getParameter("hit");
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
					fos.write(buf , 0, size);
				}
				is.close();
				fos.close();
				
			}
//			List<Part> fileList = new ArrayList<Part>();
//			for (Part part : parts) {
//				if(part.getContentType() != null) {
//					fileList.add(part);
//				}
//			}
//			
//			List<AttachmentVo> voList = new ArrayList<AttachmentVo>();
//			for (Part f : fileList) {
//				AttachmentVo attVo = FileUpload.saveFile(f);
//				voList.add(attVo);
//			}
			
//			HomeVo vo = new HomeVo();
//			vo.setNo(no);
//			vo.setGenre_no(genreNo);
//			vo.setName(name);
//			vo.setDay(day);
//			vo.setHit(hit);
			
			HomeVo vo = new HomeVo();
			vo.setNo(no);
			vo.setGenre_no(genreNo);
			vo.setName(name);
			vo.setDay(day);
			vo.setHit(hit);
			vo.setProfile(changeName);
			
			HomeService hs = new HomeService();
			int result = hs.HomeInsert(vo);
			
			System.out.println(vo);
			
			req.setAttribute("vo", vo);
			resp.sendRedirect("/webtoon/home");
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}//class
