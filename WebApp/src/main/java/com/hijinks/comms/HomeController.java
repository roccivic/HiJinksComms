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
import com.hijinks.comms.dao.impl.UserJDBCTemplate;
import com.hijinks.comms.models.User;

@Controller
public class HomeController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale, Model model, HttpSession session,
			@RequestParam(defaultValue="") String email,
			@RequestParam(defaultValue="") String password
		) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		UserJDBCTemplate userJDBCTemplate = 
	      (UserJDBCTemplate)context.getBean("userJDBCTemplate");
		
		if (userJDBCTemplate.LogIn(email, password)) {
			// FIXME: need to get the correct user object
			session.setAttribute("user", new User());
			return "home";
		} else {
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
