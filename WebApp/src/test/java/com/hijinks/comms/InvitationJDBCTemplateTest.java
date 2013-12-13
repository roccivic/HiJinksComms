package com.hijinks.comms;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hijinks.comms.dao.impl.InvitationJDBCTemplate;
import com.hijinks.comms.models.Invitation;

public class InvitationJDBCTemplateTest {
	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("config.xml");

		InvitationJDBCTemplate invitationJDBCTemplate = 
	      (InvitationJDBCTemplate)context.getBean("invitationJDBCTemplate");
		
		//create invite
		invitationJDBCTemplate.sendInvite(1, 19, 2);
		System.out.println("Created invite");
		//read invites
		List<Invitation> invitations = invitationJDBCTemplate.getInvites(2);
		for (Invitation record : invitations) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Invitee : " + record.getInvitee());
	         System.out.println("Comunity Id : " + record.getCommunity());
	         System.out.println("Invited By : " + record.getInvitedBy());
	         System.out.println("Date : " + record.getDate());
	         System.out.println("--------------------");
	      }
		
		//Get Invitation by Id
		Invitation invite = new Invitation();
		invite = invitationJDBCTemplate.getInvitationById(1,1);
		for (Invitation record : invitations) {
	         System.out.println("ID : " + record.getId());
	         System.out.println("Invitee : " + record.getInvitee());
	         System.out.println("Comunity Id : " + record.getCommunity());
	         System.out.println("Invited By : " + record.getInvitedBy());
	         System.out.println("Date : " + record.getDate());
	         System.out.println("--------------------");
	      }
		//remove invite
		invitationJDBCTemplate.deleteInvite(2, 19);
		
		
	}
}
