package com.hijinks.comms;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hijinks.comms.dao.impl.CommunityJDBCTemplate;
import com.hijinks.comms.models.Community;

public class CommunityJDBCTemplateTest {

	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("config.xml");

		CommunityJDBCTemplate communityJDBCTemplate = 
	      (CommunityJDBCTemplate)context.getBean("communityJDBCTemplate");
		
		//create Community
		communityJDBCTemplate.createCommunity("NEWEST", 1, "yeahyeah", "TEST NEWEST", true, "open", "unrestricted");
		System.out.println("Created a new Community.\n---------");
		//Add person to community
		communityJDBCTemplate.addMemberToCommunity(23, 2);
		System.out.println("Added a member.\n---------");
		//Get All Communities. Newest community ^^^^^ should be on top
		System.out.println("Get All Communities\n-------------------");
		List<Community> communities = communityJDBCTemplate.getAllCommunities(1);
		for (Community record : communities) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Name : " + record.getName());
	         System.out.println("Owner : " + record.getOwner());
	         System.out.println("Keywords : " + record.getKeywords());
	         System.out.println("Description : " + record.getDescription());
	         System.out.println("Keywords Enabled : " + record.isKeywordsEnabled());
	         System.out.println("Visibility Level : " + record.getVisibilityLevel());
	         System.out.println("Access Level : " + record.getAccessLevel());
	         System.out.println("Date Created : " + record.getCreated());
	         System.out.println("--------------------");
	      }
		//Get Communities owned by user
		System.out.println("Get Communities owned by user(1)\n-------------------");
		communities = communityJDBCTemplate.getCommunitiesOwnedByUser(1);
		for (Community record : communities) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Name : " + record.getName());
	         System.out.println("Owner : " + record.getOwner());
	         System.out.println("Keywords : " + record.getKeywords());
	         System.out.println("Description : " + record.getDescription());
	         System.out.println("Keywords Enabled : " + record.isKeywordsEnabled());
	         System.out.println("Visibility Level : " + record.getVisibilityLevel());
	         System.out.println("Access Level : " + record.getAccessLevel());
	         System.out.println("Date Created : " + record.getCreated());
	         System.out.println("--------------------");
	      }
		//Get Communities user is part of
		System.out.println("Get Communities user(2) is a part of\n-------------------");
		communities = communityJDBCTemplate.getCommunitiesOwnedByUser(2);
		for (Community record : communities) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Name : " + record.getName());
	         System.out.println("Owner : " + record.getOwner());
	         System.out.println("Keywords : " + record.getKeywords());
	         System.out.println("Description : " + record.getDescription());
	         System.out.println("Keywords Enabled : " + record.isKeywordsEnabled());
	         System.out.println("Visibility Level : " + record.getVisibilityLevel());
	         System.out.println("Access Level : " + record.getAccessLevel());
	         System.out.println("Date Created : " + record.getCreated());
	         System.out.println("--------------------");
	      }
		//Get NEWEST COMMUNITIES(TOP 10)
			System.out.println("Get NEWEST COMMUNITIES(TOP 10)\n-------------------");
			communities = communityJDBCTemplate.getNewestCommunities(1);
			for (Community record : communities) {
		         System.out.println("ID : " + record.getId());
		         System.out.println("Name : " + record.getName());
		         System.out.println("Owner : " + record.getOwner());
		         System.out.println("Keywords : " + record.getKeywords());
		         System.out.println("Description : " + record.getDescription());
		         System.out.println("Keywords Enabled : " + record.isKeywordsEnabled());
		         System.out.println("Visibility Level : " + record.getVisibilityLevel());
		         System.out.println("Access Level : " + record.getAccessLevel());
		         System.out.println("Date Created : " + record.getCreated());
		         System.out.println("--------------------");
			}	
	}		
}