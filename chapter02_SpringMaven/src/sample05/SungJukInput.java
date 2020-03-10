package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* 
 @Setter 삭제-> <property ~~~> 역시 삭제
 @Component 로 생성된 것 중에서 List를 생성한 것을 찾아서 알아서 연결해라. ---> @Autowired
 */
@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Qualifier("list")
	@Autowired
	private List <SungJukDTO> list;
	@Autowired
	private SungJukDTO sungJukDTO;
	
	private Scanner scan;

	@Override
	public void execute() {
		scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		sungJukDTO.setName(scan.next());

		System.out.print("국어점수 입력 : ");
		sungJukDTO.setKor(scan.nextInt());

		System.out.print("영어점수 입력 : ");
		sungJukDTO.setEng(scan.nextInt());

		System.out.print("수학점수 입력 : ");
		sungJukDTO.setMath(scan.nextInt());
		
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
		
		list.add(sungJukDTO);

		System.out.println(sungJukDTO.getName() + "님의 데이터를 입력하셨습니다.");
	}

}
