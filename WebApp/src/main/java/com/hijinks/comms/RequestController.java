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
import com.hijinks.comms.service.RequestService;

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
		return "requests";
	}
}
