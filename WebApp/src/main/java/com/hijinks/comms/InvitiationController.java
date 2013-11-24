package com.hijinks.comms;

import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hijinks.comms.models.User;
import com.hijinks.comms.service.InvitationService;

@Controller
public class InvitiationController extends CommonHandler {
	@RequestMapping(value = "/invitations", method = RequestMethod.GET)
	public String invitations(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		InvitationService invitationService = 
	      (InvitationService)context.getBean("invitationService");

		model.addAttribute(
			"invitations",
			invitationService.getInvites(
				((User)session.getAttribute("user")).getId()
			)
		);
		return "invitations";
	}
	@RequestMapping(value = "/invitations/{id}", method = RequestMethod.GET)
	public String community(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		InvitationService invitationService = 
	      (InvitationService)context.getBean("invitationService");

		model.addAttribute(
			"invitation",
			invitationService.getInvitationById(
				Integer.parseInt(id),
				((User)session.getAttribute("user")).getId()
			)
		);
		return "invitation";
	}
	@RequestMapping(value = "/declineInvitation/{id}", method = RequestMethod.GET)
	public String declineRequest(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		InvitationService invitationService = 
	      (InvitationService)context.getBean("invitationService");

		invitationService.deleteInvite(
			Integer.parseInt(id),
			((User)session.getAttribute("user")).getId()
		);
		model.addAttribute(
			"requests",
			invitationService.getInvites(
				((User)session.getAttribute("user")).getId()
			)
		);
		model.addAttribute(
			"messageType",
			"notice"
		);
		model.addAttribute(
			"messageText",
			"Successfully rejected invitation"
		);
		return "invitations";
	}
	@RequestMapping(value = "/acceptInvitation/{id}", method = RequestMethod.GET)
	public String acceptRequest(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		InvitationService invitationService = 
	      (InvitationService)context.getBean("invitationService");

		invitationService.acceptInvite(
			Integer.parseInt(id),
			((User)session.getAttribute("user")).getId()
		);
		model.addAttribute(
			"invitations",
			invitationService.getInvites(
				((User)session.getAttribute("user")).getId()
			)
		);
		model.addAttribute(
			"messageType",
			"notice"
		);
		model.addAttribute(
			"messageText",
			"Successfully accepted invitation"
		);
		return "invitations";
	}
}
