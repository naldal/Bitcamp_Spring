package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean = new MessageBeanEn(); //결합도 낮추기, 부모=자식
		bean.sayHello("spring");
		
	}
}
