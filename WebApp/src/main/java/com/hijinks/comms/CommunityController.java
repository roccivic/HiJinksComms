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
import org.springframework.web.bind.annotation.RequestParam;

import com.hijinks.comms.models.User;
import com.hijinks.comms.service.CommunityService;
import com.hijinks.comms.service.UserService;

@Controller
public class CommunityController extends CommonHandler {
	@RequestMapping(value = "/newestCommunities", method = RequestMethod.GET)
	public String newestCommunities(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");

		model.addAttribute(
			"communities",
			communityService.getNewestCommunities()
		);
		return "newestCommunities";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");

		model.addAttribute(
			"communities",
			communityService.getAllCommunities()
		);
		return "search";
	}
	@RequestMapping(value = "/communities/{id}", method = RequestMethod.GET)
	public String community(@PathVariable String id, Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");

		model.addAttribute(
			"community",
			communityService.getCommunityById(Integer.parseInt(id))
		);
		
		UserService userService = 
	      (UserService)context.getBean("userService");

		model.addAttribute(
			"users",
			userService.getMembersOfCommunity(Integer.parseInt(id))
		);
		return "community";
	}
	@RequestMapping(value = "/communitiesYouOwn", method = RequestMethod.GET)
	public String communitiesYouOwn(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");

		model.addAttribute(
			"communities",
			communityService.getCommunitiesOwnedByUser(
				((User)session.getAttribute("user")).getId()
			)
		);
		return "communitiesYouOwn";
	}
	@RequestMapping(value = "/communitiesYouArePartOf", method = RequestMethod.GET)
	public String communitiesYouArePartOf(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");

		model.addAttribute(
			"communities",
			communityService.getCommunitiesUserIsPartOf(
				((User)session.getAttribute("user")).getId()
			)
		);
		return "communitiesYouOwn";
	}
	@RequestMapping(value = "/createCommunity", method = RequestMethod.GET)
	public String createCommunity(Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "createCommunity";
	}
	
	@RequestMapping(value = "/creatingCommunity", method = RequestMethod.POST)
	public String creatingCommunity(
									@RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String description,
									@RequestParam(defaultValue="") String keywords, @RequestParam(defaultValue="") boolean keywordsEnabled, @RequestParam(defaultValue="") String visibilityLevel,
									@RequestParam(defaultValue="") String accessLevel, 
									Locale locale, Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		System.out.println(name);
		if(name == "" || description == "")
		{
			model.addAttribute("error", "Please, populate all mandatory fields");
			model.addAttribute("name", name);
			model.addAttribute("description", description);
			model.addAttribute("keywords", keywords);
			model.addAttribute("keywordsEnabled", keywordsEnabled);
			model.addAttribute("visibilityLevel", visibilityLevel);
			model.addAttribute("accessLevel", accessLevel);
			return "createCommunity";
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");
		communityService.createCommunity(name, ((User) session.getAttribute("user")).getId(), keywords, description, keywordsEnabled, visibilityLevel, accessLevel);
		model.addAttribute("message", "Community created successfully");
		return "home";
	}
}
