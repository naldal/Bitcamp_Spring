package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Setter
@Component
public class SungJukDelete implements SungJuk{
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO> list;

	@Override
	public void execute() {
		System.out.println("삭제할 이름을 입력하세요");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
			}
		}
		System.out.println("삭제되었습니다.");
	}
}
