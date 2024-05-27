package webtoon.admin.service;

import org.apache.ibatis.session.SqlSession;

import webtoon.admin.dao.AdminDao;
import webtoon.admin.vo.AdminVo;
import webtoon.db.SqlSessionTemplate;

public class AdminService {

	private final AdminDao dao;
	
	public AdminService(AdminDao dao) {
		this.dao = dao;
	}
	
    public AdminVo login(AdminVo vo) throws Exception {
    	//비즈니스 로직
    	
    	//DAO 호출
        SqlSession ss = SqlSessionTemplate.getSqlSession();
        try {
            AdminVo loginAdminVo = dao.getAdminVo(ss, vo);
            return loginAdminVo;
        } finally {
            ss.close();
        }
    }

}
