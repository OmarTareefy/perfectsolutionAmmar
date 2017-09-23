package net.perfectsolution.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.ContactMessage;

@Controller
public class PageController {
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");		
		mv.addObject("userClickHome", true);
		List list = serviceDAO.listActiveServices();
		mv.addObject("services", list);
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
			mv.addObject("success", "success");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String handleContactMessageSubmission(@ModelAttribute("contactMessage") ContactMessage mContactMessage,
			Model model, HttpServletRequest request) {

		System.out.println(mContactMessage);

		return "redirect:/contact/?operation=success";
	}


}
