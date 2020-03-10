package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcAdd implements Calc {
	
	private @Value("25") int num1;
	private @Value("36") int num2;

	@Override
	public void calculate() {
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
	}

}
