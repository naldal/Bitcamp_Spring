package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukModify implements SungJuk{
	@Setter
	private List<SungJukDTO> list;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 이름 입력");
		String name = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				
				System.out.println("국어점수 입력");
				int kor = scan.nextInt();
				list.get(i).setKor(kor);
				
				System.out.println("영어점수 입력");
				int eng = scan.nextInt();
				list.get(i).setEng(eng);
				
				System.out.println("수학점수 입력");
				int math = scan.nextInt();
				list.get(i).setMath(math);
				
				list.get(i).setTot(kor+eng+math);
				list.get(i).setAvg(list.get(i).getTot()/3.0);
			} else {
				System.out.println("잘못된 이름입니다.");
			}
		}
		System.out.println(name+"님의 데이터가 수정되었습니다.");
	}
}
