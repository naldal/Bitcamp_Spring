package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import user.bean.UserDTO;
import user.dao.UserDAO;

@ComponentScan("user.conf")
public class UserSelectService implements UserService{

	@Autowired
	UserDAO userDAO;

	@Override
	public void execute() {		
		//DB
		List<UserDTO> list = userDAO.getUserList();
		
		//응답
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"
								+userDTO.getId()+"\t"
								+userDTO.getPwd());
		}
	}

}
