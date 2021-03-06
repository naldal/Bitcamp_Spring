package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

@Repository("memberDAO")
@Transactional
public class MemberDAOMybatis implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDTO login(Map<String, String> map) {
		return sqlSession.selectOne("memberSQL.login", map);
	}

	@Override
	public MemberDTO isExistId(String id) {
		return sqlSession.selectOne("memberSQL.isExistId", id);
	}

	@Override
	public List<ZipcodeDTO> postSearch(Map<String, String> map) {
		return sqlSession.selectList("memberSQL.postSearch", map);
	}

	@Override
	public int write(MemberDTO memberDTO) {
		return sqlSession.insert("memberSQL.write", memberDTO);
	}

}
