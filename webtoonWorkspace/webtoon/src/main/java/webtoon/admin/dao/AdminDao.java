package webtoon.admin.dao;

import org.apache.ibatis.session.SqlSession;

import webtoon.admin.vo.AdminVo;

public class AdminDao {

	public AdminVo getAdminVo(SqlSession ss, AdminVo vo) {
		return ss.selectOne("AdminMapper.adminLogin", vo);
		
	
	}

}
