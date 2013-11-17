package com.hijinks.comms;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hijinks.comms.dao.impl.AnnouncementJDBCTemplate;
import com.hijinks.comms.models.Announcement;

public class AnnouncementJDBCTemplateTest {
	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("config.xml");

		AnnouncementJDBCTemplate announcementJDBCTemplate = 
	      (AnnouncementJDBCTemplate)context.getBean("announcementJDBCTemplate");
		
		//create invite
		announcementJDBCTemplate.makeAnnouncement("Test", "Test",  3, 1);
		System.out.println("Created invite");
		//read invites
		List<Announcement> announcements = announcementJDBCTemplate.getAnnouncements(3);
		for (Announcement record : announcements) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Title : " + record.getTitle());
	         System.out.println("Text : " + record.getText());
	         System.out.println("Community Id : " + record.getCommunity().getId());
	         System.out.println("Created By : " + record.getCreatedBy().getEmail());
	         System.out.println("Date : " + record.getDate());
	         System.out.println("--------------------");
		}
	}
}
