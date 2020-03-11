package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;


@SuppressWarnings("unused")
@Component
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	@Autowired
	BasicDataSource dataSource;
	
	@PostConstruct
	public void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public void userWrite(UserDTO userDTO) {		
		String sql = "insert into usertable values(:name,:id,:pwd)";
		Map<String, String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id = (:id)";
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		
		try {
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public void updateUser(UserDTO userDTO) {
		String sql = "update usertable set name = (:name), pwd = (:pwd) where id = (:id)";
		Map<String, String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void deleteUser(String id) {
		String sql = "delete usertable where id = (:id)";
		
		getJdbcTemplate().update(sql, id);
	}
}
