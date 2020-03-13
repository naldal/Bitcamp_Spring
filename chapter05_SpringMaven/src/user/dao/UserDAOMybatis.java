package user.dao;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional
@ComponentScan("user.conf")
public class UserDAOMybatis implements UserDAO{
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void userWrite(UserDTO userDTO) {
		sqlSession.insert("userSQL.userWrite", userDTO);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		sqlSession.update("userSQL.updateUser", userDTO);
		
	}

	@Override
	public void deleteUser(String id) {
		sqlSession.delete("userSQL.deleteUser", id);
		
	}
}
