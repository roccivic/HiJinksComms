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

import com.hijinks.comms.service.UserService;

@Controller
public class UserController extends CommonHandler {
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		UserService userService = 
	      (UserService)context.getBean("userService");

		model.addAttribute(
			"users",
			userService.searchForMembers("", "", "")
		);
		return "users";
	}
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String community(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		UserService userService = 
	      (UserService)context.getBean("userService");

		model.addAttribute(
			"user",
			userService.getUserById(Integer.parseInt(id))
		);
		return "user";
	}
}
