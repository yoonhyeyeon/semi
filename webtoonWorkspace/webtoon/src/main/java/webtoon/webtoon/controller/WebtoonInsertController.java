package webtoon.webtoon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resources;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import webtoon.admin.vo.AdminVo;
import webtoon.util.file.FileUpload;
import webtoon.webtoon.service.WebtoonService;
import webtoon.webtoon.vo.AttachmentVo;
import webtoon.webtoon.vo.CategoryVo;
import webtoon.webtoon.vo.WebtoonVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 500 ,
		fileSizeThreshold = 1024 * 1024 * 50
		)


@WebServlet("/webtoon/insert")
public class WebtoonInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        WebtoonService ws = new WebtoonService();
	        String webtoonNo = req.getParameter("webtoonNo"); // 웹툰 번호를 요청 파라미터에서 가져옴
	        List<AttachmentVo> attachments = ws.getAttachment(webtoonNo); // 특정 웹툰의 이미지 목록을 가져옴
	        req.setAttribute("uploadedImages", attachments); // 요청 객체에 이미지 목록을 속성으로 추가

	        List<CategoryVo> categoryVoList = ws.getCategoryVoList();
	        req.setAttribute("categoryVoList", categoryVoList); // 카테고리 정보도 함께 전달
	        req.getRequestDispatcher("/WEB-INF/views/webtoon/insert.jsp").forward(req, resp);
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
			
			//데꺼
			Collection<Part> parts = req.getParts();
			
			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if(part.getContentType() != null) {
					fileList.add(part);
				}
			}
			
			//서버에 파일 업로드  // 여기 코드에서 
			List<AttachmentVo> voList = new ArrayList<AttachmentVo>();
			for (Part f : fileList) {
				AttachmentVo attVo = FileUpload.saveFile(f);
				voList.add(attVo);
			}
			
			System.out.println("parts : " + parts);
			

			
			// 서비스 호출
			WebtoonService ws = new WebtoonService();
			int result = ws.insertWebtoonAttachment(voList);
			
			// 결과
			if(result < 1) {
				throw new Exception("사진 업로드 실패 ...!!!");
			}
			resp.sendRedirect("/webtoon/webtoon/display");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		
		}
		
		
		
	}//method
}//class





















