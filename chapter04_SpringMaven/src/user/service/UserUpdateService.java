package user.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
@Component
public class UserUpdateService implements UserService {
	@Autowired
	UserDTO userDTO;
	@Autowired
	UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정 할 아이디 입력 : ");
		String id = scan.next();

		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO != null) {
			System.out.println("수정할 이름 입력 : ");
			String name = scan.next();
			userDTO.setName(name);

			userDTO.setId(id);

			System.out.println("수정할 비밀번호 입력 : ");
			String pwd = scan.next();
			userDTO.setPwd(pwd);

			userDAO.updateUser(userDTO);

			System.out.println("데이터를 수정하였습니다.");
		} else {
			System.out.println("아이디가 없습니다.");
			return;
		}
	}
}
