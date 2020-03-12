package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.dao.UserDAO;

public class UserDeleteService implements UserService{
	@Setter
	UserDAO userDAO;
	
	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		userDAO.deleteUser(id);
		
		System.out.println("데이터를 삭제하였습니다.");
		
	}

}
