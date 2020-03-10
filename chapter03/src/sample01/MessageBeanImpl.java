package sample01;

import lombok.Setter;

@Setter
public class MessageBeanImpl implements MessageBean {
	private String str;

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = " + str); // 핵심관심사항
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메시지 = " + str); // 핵심관심사항

	}
	
	@Override
	public void showPrintAfter() {
		System.out.println("showPrintBefore 메시지 = " + str); // 핵심관심사항
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메시지 = " + str); // 핵심관심사항

	}

	@Override
	public void display() {
		System.out.println("showPrintBefore 메시지 = " + str); // 핵심관심사항

	}

	@Override
	public String showPrint() {
		System.out.println("showPrint 메시지 = " + str); // 핵심관심사항
		return "ob return";
	}

	@Override
	public void viewPrint() {
		System.out.println("viewPrint 메시지 = " + str); // 핵심관심사항
	}
}
