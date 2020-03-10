package com.comf;

import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import sample05.SungJukDTO;
import sample03.SungJukImpl;
import sample05.HelloSpring;
import sample05.SungJukInput;
import sample05.SungJukOutput;

//@Configuration : 설정파일의 역할을 한다
@Configuration
public class Instance {
	// 메소드명을 객체명으로 인식한다
	// 그래서 객체명을 getSungJukImpl로 찾으니 없어서 name = "sungJukImpl"을 부여한 것이다.
//	@Bean(name="sungJukImpl")
//	public SungJukImpl getSungJukImpl() {
//		return new SungJukImpl();
//	}


	@Bean(name="list")
	public List<SungJukDTO> getArrayList() {
		return new ArrayList<SungJukDTO>();
	}

}
