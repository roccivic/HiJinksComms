package com.hijinks.comms;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hijinks.comms.models.User;
import com.hijinks.comms.service.UserService;

@Controller
public class HomeController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale, Model model, HttpSession session,
			@RequestParam(defaultValue="") String email,
			@RequestParam(defaultValue="") String password
		) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		UserService userService = 
	      (UserService)context.getBean("userService");
		
		User currentUser = userService.LogIn(email, password);
		
		if (currentUser != null) {
			session.setAttribute("user", currentUser);
			return "home";
		} else {
			model.addAttribute("errorClass", "notification error");
			model.addAttribute("errorMsg", "Invalid email or password");
			model.addAttribute("email", email);
			return "login";
		}
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "home";
	}
	@RequestMapping(value = "/logout")
	public String logOut(Locale locale, Model model, HttpSession session) {
		session.setAttribute("user", null);
		return "login";
	}
}
