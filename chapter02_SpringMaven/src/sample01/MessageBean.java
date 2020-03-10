package sample01;

import org.springframework.stereotype.Component;

@Component
public interface MessageBean {
	public void sayHello();
	public void sayHello(String fruit, int cost);
	public void sayHello(String fruit, int cost, int qty);

}
