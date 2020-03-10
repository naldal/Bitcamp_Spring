package sample05;

import java.util.Scanner; 
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {

	Scanner sc;
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	double avg;
	
	public SungJukImpl() {
		sc = new Scanner(System.in);
	}
	
	@Override
	public void calc() {
		System.out.println("이름 입력 : ");
		name = sc.next();
		
		System.out.println("국어 입력 : ");
		kor = sc.nextInt();
		
		System.out.println("영어 입력 : ");
		eng = sc.nextInt();
		
		System.out.println("수학 입력 : ");
		math = sc.nextInt();
		
		tot = kor+eng+math;
		avg = tot/3.0;
	}

	@Override
	public void display() {
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+avg);
	}

}
