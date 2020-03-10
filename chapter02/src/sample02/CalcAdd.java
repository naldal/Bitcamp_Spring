package sample02;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalcAdd implements Calc {
	
	private int num1;
	private int num2;
	
	@Override
	public void calculate() {
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
	}

}
