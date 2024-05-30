package webtoon.util.file;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

import webtoon.webtoon.vo.AttachmentVo;

public class FileUpload {

	public static AttachmentVo saveFile(Part f) throws Exception{
		
		InputStream is = f.getInputStream();
		String path = "D:\\dev\\webtoon\\webtoonWorkspace\\webtoon\\src\\main\\webapp\\resources\\uploadimg\\";
		int random = (int)(Math.random() * 90000) + 10000;
		String originName = f.getSubmittedFileName();
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = "MOONTOON_" + System.nanoTime() + "_" + random + ext;
		FileOutputStream fos = new FileOutputStream(path + changeName);
		
		byte[] buf = new byte[1024];
		int size = 0;
		while( (size=is.read(buf)) != -1 ) {
			fos.write(buf , 0, size);
		}
		
		is.close();
		fos.close();
		
		AttachmentVo attVo = new AttachmentVo();
		attVo.setChangeName(changeName);
		attVo.setOriginName(originName);
		
		return attVo;
		
		
	}
	
}
