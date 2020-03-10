package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

//@Component
@ComponentScan("com.comf")
public class SungJukImpl implements SungJuk {
//	Component되면서 기본생성자 처리를 통해 sungJukDTO가 자동적으로 주입이 된다.
	
	@Autowired
	//@Autowired는 @Component로 생성된 것들 중에서 찾는다. 지금은 @Component설정이 된 SungJukDTO 타입을 찾는다. (변수 sungJukDTO 찾는 것 아님)
	private SungJukDTO sungJukDTO;
	
	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름입력 : ");
		sungJukDTO.setName(scan.next());
		System.out.print("국어입력 : ");
		sungJukDTO.setKor(scan.nextInt());
		System.out.print("영어입력 : ");
		sungJukDTO.setEng(scan.nextInt());
		System.out.print("수학입력 : ");
		sungJukDTO.setMath(scan.nextInt());
	}

}
