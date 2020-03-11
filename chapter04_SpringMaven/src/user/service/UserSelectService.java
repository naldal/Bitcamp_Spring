package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserSelectService implements UserService{

	@Setter
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
