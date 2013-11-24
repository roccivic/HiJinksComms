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

}
