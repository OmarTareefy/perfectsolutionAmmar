package net.perfectsolution.frontend.controller;

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

import net.perfectsolution.backend.dao.AboutDAO;
import net.perfectsolution.backend.dto.About;

@Controller
@RequestMapping("/manage")
public class AdminController {
	
	@Autowired
	AboutDAO aboutDAO;
	
	@RequestMapping(value = {"/home","/","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Home");		
		mv.addObject("userClickAdminHome", true);
		return mv;
	}
	
	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
	public ModelAndView about(@RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "About");		
		mv.addObject("userClickAdminAbout", true);
		About about = aboutDAO.get(1);
		mv.addObject("about", about);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}

	
	@RequestMapping(value = {"/about"}, method = RequestMethod.POST)
	public String handleAboutSubmit(@Valid @ModelAttribute("about") About mAbout, BindingResult results, Model model){
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "About");		
			model.addAttribute("userClickAdminAbout", true);
			return "/adminViews/adminPage";
		}
		mAbout.setId(1);
		if(aboutDAO.updateAbout(mAbout)){
			return "redirect:/manage/about?operation=success";
		}else{
			return "redirect:/manage/about?operation=failure";
		}
		
	}

	
}
