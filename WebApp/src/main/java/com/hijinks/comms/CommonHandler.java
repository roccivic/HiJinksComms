package com.hijinks.comms;

import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.hijinks.comms.models.Menu;
import com.hijinks.comms.models.User;
import com.hijinks.comms.service.MenuService;

public class CommonHandler {
	@ModelAttribute("menu")
	public Menu getMenu(HttpSession session) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		MenuService menuService = 
	      (MenuService)context.getBean("menuService");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return menuService.getMenu(user.getId());
		} else {
			return new Menu();
		}
	}
}