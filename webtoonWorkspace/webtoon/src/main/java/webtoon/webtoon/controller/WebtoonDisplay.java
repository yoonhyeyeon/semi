package webtoon.webtoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtoon.webtoon.service.WebtoonService;
import webtoon.webtoon.vo.AttachmentVo;


@WebServlet("/webtoon/display")
public class WebtoonDisplay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            WebtoonService ws = new WebtoonService();
            List<AttachmentVo> attachments = ws.getAllAttachments();  // 모든 첨부 파일의 정보를 가져옵니다.
            req.setAttribute("uploadedImages", attachments);  // 이미지 정보를 요청 속성으로 추가합니다.
            req.getRequestDispatcher("/WEB-INF/views/webtoon/details2.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
