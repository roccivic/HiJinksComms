package com.hijinks.comms;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hijinks.comms.dao.impl.RequestJDBCTemplate;
import com.hijinks.comms.models.Request;

public class RequestJDBCTemplateTest {
	public static void 
	printRequests(List<Request> request) {
		for (Request record : request) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Community id : " + record.getCommunity().getId());
	         System.out.println("Created : " + record.getDate());
	         System.out.println("User id: " + record.getUser().getId());
	         System.out.println("--------------------");
	    }
	}
	
	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("config.xml");

		RequestJDBCTemplate requestJDBCTemplate = 
	      (RequestJDBCTemplate)context.getBean("requestJDBCTemplate");

		System.out.println("Printing requests");
		printRequests(requestJDBCTemplate.getRequests(5));

		System.out.println("Adding request");
		requestJDBCTemplate.sendRequest(5, 1);
		printRequests(requestJDBCTemplate.getRequests(5));

		System.out.println("Decline request");
		requestJDBCTemplate.declineRequest(5, 1);
		printRequests(requestJDBCTemplate.getRequests(5));
		
	}
}
