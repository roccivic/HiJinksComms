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
import com.hijinks.comms.service.CommunityService;
import com.hijinks.comms.service.RequestService;
import com.hijinks.comms.service.UserService;

@Controller
public class RequestController extends CommonHandler {
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public String community(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		RequestService requestService = 
	      (RequestService)context.getBean("requestService");

		model.addAttribute(
			"requests",
			requestService.getRequests(
				((User)session.getAttribute("user")).getId()
			)
		);
		return "requests";
	}
	@RequestMapping(value = "/requests/{id}", method = RequestMethod.GET)
	public String community(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		RequestService requestService = 
	      (RequestService)context.getBean("requestService");

		model.addAttribute(
			"request",
			requestService.getRequestById(
				Integer.parseInt(id),
				((User)session.getAttribute("user")).getId()
			)
		);
		return "request";
	}
	@RequestMapping(value = "/declineRequest/{id}", method = RequestMethod.GET)
	public String declineRequest(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		RequestService requestService = 
	      (RequestService)context.getBean("requestService");

		requestService.declineRequest(
			Integer.parseInt(id),
			((User)session.getAttribute("user")).getId()
		);
		model.addAttribute(
			"requests",
			requestService.getRequests(
				((User)session.getAttribute("user")).getId()
			)
		);
		model.addAttribute(
			"messageType",
			"notice"
		);
		model.addAttribute(
			"messageText",
			"Successfully rejected request"
		);
		return "requests";
	}
	@RequestMapping(value = "/acceptRequest/{id}", method = RequestMethod.GET)
	public String acceptRequest(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		RequestService requestService = 
	      (RequestService)context.getBean("requestService");

		requestService.acceptRequest(
			Integer.parseInt(id),
			((User)session.getAttribute("user")).getId()
		);
		model.addAttribute(
			"requests",
			requestService.getRequests(
				((User)session.getAttribute("user")).getId()
			)
		);
		model.addAttribute(
			"messageType",
			"notice"
		);
		model.addAttribute(
			"messageText",
			"Successfully accepted request"
		);
		return "requests";
	}
	
	@RequestMapping(value = "/requestToJoin/{communityId}", method = RequestMethod.GET)
	public String requestToJoin(@PathVariable String communityId, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		RequestService requestService = 
	      (RequestService)context.getBean("requestService");
		
		CommunityService communityService = 
			      (CommunityService)context.getBean("communityService");

		requestService.sendRequest(Integer.parseInt(communityId), ((User) session.getAttribute("user")).getId());
		
		model.addAttribute(
			"community",
			communityService.getCommunityById(
				Integer.parseInt(communityId)
			)
		);
		UserService userService = 
			      (UserService)context.getBean("userService");
				
				model.addAttribute(
					"users",
					userService.getMembersOfCommunity(Integer.parseInt(communityId))
				);
		model.addAttribute(
				"messageType",
				"notice"
			);
		
		model.addAttribute(
			"messageText",
			"The request to join the community is sent successfully"
		);
		return "community";
	}
}
