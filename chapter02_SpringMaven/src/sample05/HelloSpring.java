package sample05;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import sample05.SungJuk;

@Component("helloSpring")
public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
	}

	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;

		while (true) {
			System.out.println();
			System.out.println("************");
			System.out.println("  1. 입력");
			System.out.println("  2. 출력");
			System.out.println("  3. 수정");
			System.out.println("  4. 삭제");
			System.out.println("  5. 끝");
			System.out.println("************");
			System.out.print("번호 : ");
			int choice = scan.nextInt();

			if (choice == 1) {
				sungJuk = (SungJuk) context.getBean("sungJukInput");
			} else if (choice == 2) {
				sungJuk = (SungJuk) context.getBean("sungJukOutput");
			} else if (choice == 3) {
				sungJuk = (SungJuk) context.getBean("sungJukModify");
			} else if (choice == 4) {
				sungJuk = (SungJuk) context.getBean("sungJukDelete");
			} else if (choice == 5) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.(1~5)");
				continue;
			}
			sungJuk.execute();
		}
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}
}
