package user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.service.UserService;

@Repository("userDAO")
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO checkId(String id) {
		return sqlSession.selectOne("userSQL.checkId", id);
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void modify(UserDTO userDTO) {
		 sqlSession.update("userSQL.modify", userDTO);
		
	}

	@Override
	public int delete(String id) {
		return sqlSession.delete("userSQL.deleteUser", id);
	}

}
