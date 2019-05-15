package com.mnmlyn;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mnmlyn.service.OrderService;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		OrderService orderService = applicationContext.getBean(OrderService.class);
		orderService.initOrder("1");
		
		System.out.println("�������...");
		System.in.read();
	}

}
