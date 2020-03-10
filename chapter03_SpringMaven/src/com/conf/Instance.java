package com.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample01.MessageBeanImpl;
import sample01.LoggingAdvice;

@Configuration
public class Instance {

	@Bean(name="messageBeanImpl")
	public MessageBeanImpl getMessageBeanImpl() {
		return new MessageBeanImpl();
	}
	
	@Bean(name="loggingadvice")
	public LoggingAdvice getLoggingAdvice() {
		return new LoggingAdvice();
	}
}
