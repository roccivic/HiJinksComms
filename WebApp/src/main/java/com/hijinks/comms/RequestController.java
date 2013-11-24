package com.hijinks.comms;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
