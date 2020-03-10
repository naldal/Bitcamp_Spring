package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	
	private int num1;
	private int num2;

	@Autowired
	//setter는 자동으로 주입해주지 않으므로 Setter에는 Autowired를 써줘야한다
	public void setNum1(@Value("25") int num1) {
		this.num1 = num1;
	}

	@Autowired
	public void setNum2(@Value("36") int num2) {
		this.num2 = num2;
	}
	
	@Override
	public void calculate() {
		System.out.println(num1+" * "+num2+" = "+(num1*num2));
	}
 
}
