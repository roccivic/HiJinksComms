package com.hijinks.comms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hijinks.comms.models.Community;
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
	public ModelAndView createCommunity(Locale locale, Model model, HttpSession session) {
		ModelMap map=new ModelMap();
		map.addAttribute("Community", new Community());
		
		if (session.getAttribute("user") == null) {
			return new ModelAndView("login", map);
		}
		return new ModelAndView("createCommunity", map);
	}
	
	@RequestMapping(value = "/createCommunity", method = RequestMethod.POST)
	public String addSinger(@ModelAttribute("Community") @Valid Community community, BindingResult result, ModelMap model, HttpSession session) {	

		if(result.hasErrors())		
			return "createCommunity";			
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

		CommunityService communityService = 
	      (CommunityService)context.getBean("communityService");
		Community newCommunity = communityService.createCommunity(community.getName(), ((User) session.getAttribute("user")).getId(), community.getKeywords(), community.getDescription(), community.isKeywordsEnabled(), community.getVisibilityLevel(), community.getAccessLevel());
		model.addAttribute(
			"community",
			newCommunity
		);
		
		UserService userService = 
	      (UserService)context.getBean("userService");

		model.addAttribute(
			"users",
			userService.getMembersOfCommunity(newCommunity.getId())
		);

		return "community";
	}

}
