package sample02;

import lombok.Setter;

public class CalcMul implements Calc {

	@Setter
	private int num1, num2;

	@Override
	public void calculate() {
		System.out.println(num1+" * "+num2+" = "+(num1*num2));
	}

}
