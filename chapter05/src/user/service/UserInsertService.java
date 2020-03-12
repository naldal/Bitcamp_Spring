package user.service;

import java.util.Scanner; 

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserInsertService implements UserService {

	private UserDTO userDTO;
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);

		// 데이터
		System.out.println("이름 입력 : ");
		String name = scan.next();
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		System.out.println("비밀번호 입력 : ");
		String pwd = scan.next();

		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);

		// DB
		userDAO.userWrite(userDTO);

		// 응답
		System.out.println("데이터를 저장하였습니다.");
	}

}
