package com.bhz.eps.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bhz.eps.entity.NozzleOrder;
import com.bhz.eps.service.NozzleOrderService;

public class NozzleOrderServiceTest {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"conf/application-context.xml"});
	@Before
	public void init(){
		
	}
	
	@Test
	public void addOrderTest(){
		NozzleOrderService nos = ctx.getBean("nozzleOrderService",NozzleOrderService.class);
		NozzleOrder no = new NozzleOrder();
		no.setWorkOrder("order1");
		no.setNozzleNumber("e-14");
		no.setOilType(1);
		no.setOilCategory(10);
		no.setPrice(569);
		no.setVolumeConsume(new BigDecimal(41.2));
		nos.addOrder(no);
	}
	
	@Test
	public void getOrderTest(){
		NozzleOrderService nos = ctx.getBean("nozzleOrderService",NozzleOrderService.class);
		NozzleOrder no = nos.getOrder();
		System.out.println(no.getPrice() + "\t" + no.getVolumeConsume());
	}
	
	@Test
	public void t1(){
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
