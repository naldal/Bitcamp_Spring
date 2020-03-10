package sample04;

public class MessageBeanImpl2 implements MessageBean {

	private String name;	//생성자 인젝션
	private String phone;	//세터 인젝션
	private Outputter outputter;

	public void setOutputter(Outputter outputter) {
		System.out.println("setOutputter(Outputter outputter)");
		this.outputter = outputter;
	}

	public MessageBeanImpl2(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public void helloCall() {
		System.out.println("이름은 = "+name+",전화번호 = "+phone);
		outputter.output("이름="+name+", 핸드폰 = "+phone);
		
	}

}
