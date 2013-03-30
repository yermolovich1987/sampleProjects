package com.dimasco.restclient;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartClient_REST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		RestClient restClient = (RestClient) context.getBean("restClient");
		
		Foo foo = new Foo();
		foo.setName("test post");
		foo.setDate(new Date());
		
		long id = restClient.postFooObject(foo);
		
		System.out.println("Created new foo record with id: " + id);
		
		foo = new Foo();
		foo.setId(1);
		foo.setName("updated");
		foo.setDate(new Date());
		
		restClient.putFooObject(foo);
	}
	
}
