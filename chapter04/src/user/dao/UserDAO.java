package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public void userWrite(UserDTO userDTO);

	public List<UserDTO> getUserList();
	
	public UserDTO getUser(String id);

	public void updateUser(UserDTO userDTO);
	
	public void deleteUser(String id);

	public int getUserCount(String id);

}
