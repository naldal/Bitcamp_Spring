package sample05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukOutput implements SungJuk{

	@Qualifier("list")
	@Autowired
	private List<SungJukDTO> list;
	
	@Override
	public void execute() {	
		for(SungJukDTO sungJukDTO : list) {
			System.out.println(sungJukDTO);
		}
	}
}
