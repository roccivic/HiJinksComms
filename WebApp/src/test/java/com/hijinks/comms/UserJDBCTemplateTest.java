package com.hijinks.comms;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hijinks.comms.dao.impl.UserJDBCTemplate;
import com.hijinks.comms.models.User;

public class UserJDBCTemplateTest {
	public static void printUsers(List<User> users) {
		for (User record : users) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Name : " + record.getFname() + " " + record.getLname());
	         System.out.println("Type : " + record.getType());
	         System.out.println("Email : " + record.getEmail());
	         System.out.println("--------------------");
	    }
	}
	
	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("config.xml");

		UserJDBCTemplate userJDBCTemplate = 
	      (UserJDBCTemplate)context.getBean("userJDBCTemplate");

		boolean result = userJDBCTemplate.LogIn(
			"michael.holmes@doesnotexist.com",
			"123456"
		);
		System.out.println("Valid Login: " + (result ? "OK": "FAIL"));
		result = userJDBCTemplate.LogIn(
			"michael.holmes@doesnotexist.com",
			"1234567"
		);
		System.out.println("Invalid Login: " + (result ? "FAIL": "OK"));

		System.out.println("Listing users of community 3");
		printUsers(
			userJDBCTemplate.getMembersOfCommunity(3)
		);
		System.out.println("Searching for Michael");
		printUsers(
			userJDBCTemplate.searchForMembers("", "", "michael")
		);
		System.out.println("Listing users not in community 2");
		printUsers(
			userJDBCTemplate.getUsersNotInCommunity(2)
		);
	}
}
