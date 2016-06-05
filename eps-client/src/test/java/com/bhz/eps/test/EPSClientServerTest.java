package com.bhz.eps.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bhz.eps.service.EPSClientService;

public class EPSClientServerTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"conf/application-context.xml"});
	
	@Test
	public void startServer(){
		EPSClientService eps = ctx.getBean("epsClientService",EPSClientService.class);
	}
}
