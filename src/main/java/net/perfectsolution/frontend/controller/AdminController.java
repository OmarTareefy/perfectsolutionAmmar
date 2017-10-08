package net.perfectsolution.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.perfectsolution.backend.dto.About;

@Controller
@RequestMapping("/manage")
public class AdminController {
	
	@RequestMapping(value = {"/home","/","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Home");		
		mv.addObject("userClickAdminHome", true);
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "About");		
		mv.addObject("userClickAdminAbout", true);
		About nAbout = new About();
		mv.addObject("about", nAbout);
		return mv;
	}
	
	
}
