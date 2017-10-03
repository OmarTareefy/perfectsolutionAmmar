package net.perfectsolution.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.perfectsolution.backend.dao.AboutDAO;
import net.perfectsolution.backend.dao.ContactMessageDAO;
import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.ContactMessage;

@Controller
public class PageController {
	
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@Autowired
	ContactMessageDAO contactMessageDAO;
	
	@Autowired
	AboutDAO aboutDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");		
		mv.addObject("userClickHome", true);
		return mv;
	}

	
	@RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
	public ModelAndView contact(@RequestParam(name = "operation", required = false) String operation){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		ContactMessage nContactMessage = new ContactMessage();
		mv.addObject("contactMessage", nContactMessage);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String handleContactMessageSubmission(@ModelAttribute("contactMessage") ContactMessage mContactMessage,
			Model model, HttpServletRequest request) {
		
		if(contactMessageDAO.sendContactMessage(mContactMessage)){
			return "redirect:/contact/?operation=success";
		}else{
			return "redirect:/contact/?operation=failure";
		}
		
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		mv.addObject("about", aboutDAO.get(1));
		return mv;
	}

	
	@RequestMapping(value = "/service/{id}")
	public ModelAndView service(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Service");
		mv.addObject("userClickService", true);
		mv.addObject("service", serviceDAO.get(id));
		return mv;
	}
}
