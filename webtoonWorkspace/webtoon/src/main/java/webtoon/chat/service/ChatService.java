package webtoon.chat.service;

import static webtoon.db.JDBCTemplate.close;
import static webtoon.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import webtoon.chat.dao.ChatDao;
import webtoon.chat.vo.ChatVo;

public class ChatService {

	private static ChatService cs = new ChatService();
	private ChatService() {}
	public static ChatService getInstance() {
		return cs;
	}
	
	public boolean update(ChatVo vo) throws Exception {
		Connection conn = getConnection();
		ChatDao dao = ChatDao.getInstance();
		dao.setConnection(conn);
		
		boolean flag = false;
		try {
			ChatVo res = dao.getOne(vo.getMemberNo()); // id 검색
			if(res.getMemberNo().equals(vo.getMemberNo())){
				dao.update(vo);
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return flag;
	}
	
	public boolean delete(String no, String memberNo) throws Exception {
		Connection conn = getConnection();
		ChatDao dao = ChatDao.getInstance();
		dao.setConnection(conn);
		
		boolean flag = false;
		try {
			ChatVo res = dao.getOne(memberNo);
			if( res.getMemberNo().equals(memberNo) ) {
				dao.delete(memberNo);
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		close(conn);
		return flag;
	}
	
	public void insert(ChatVo vo) throws Exception {
		Connection conn = getConnection();
		ChatDao dao = ChatDao.getInstance();
		dao.setConnection(conn);
		
		try {
			dao.insert(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
	}

	public int getCount(String no) throws Exception {
		Connection conn = getConnection();
		ChatDao dao = ChatDao.getInstance();
		dao.setConnection(conn);
		
		int cnt = 0;
		try {
			cnt = dao.getCount(no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		close(conn);
		return cnt;
	}
	
	public ArrayList<ChatVo> getList(String refEpisodeNo) throws Exception {
		ArrayList<ChatVo> list = null;
		Connection conn = getConnection();
		ChatDao dao = ChatDao.getInstance();
		dao.setConnection(conn);
		
		try {
			list = dao.getList(refEpisodeNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return list;
	}
	
}//class
