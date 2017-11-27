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
import net.perfectsolution.backend.dao.CategoryDAO;
import net.perfectsolution.backend.dao.ClientDAO;
import net.perfectsolution.backend.dao.ContactMessageDAO;
import net.perfectsolution.backend.dao.ProductDAO;
import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.Client;
import net.perfectsolution.backend.dto.ContactMessage;
import net.perfectsolution.backend.dto.Product;
import net.perfectsolution.backend.dto.Service;

@Controller
public class PageController {
	
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ContactMessageDAO contactMessageDAO;
	
	@Autowired
	AboutDAO aboutDAO;
	
	@Autowired
	CategoryDAO categoryDAO;	
	
	@Autowired
	ClientDAO clientDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("/clientViews/page");
		mv.addObject("title", "Home");		
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("/adminViews/login");
		return mv;
	}
	
	@RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
	public ModelAndView contact(@RequestParam(name = "operation", required = false) String operation){
		ModelAndView mv = new ModelAndView("/clientViews/page");
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
		ModelAndView mv = new ModelAndView("/clientViews/page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		mv.addObject("about", aboutDAO.get(1));
		return mv;
	}

	
	@RequestMapping(value = "/service/{id}")
	public ModelAndView service(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("/clientViews/page");
		mv.addObject("title", "Service");
		mv.addObject("userClickService", true);
		Service service = serviceDAO.get(id);
		mv.addObject("service", service);
		mv.addObject("category", categoryDAO.get(service.getCategoryId()));
		mv.addObject("services", serviceDAO.listCategoryActiveServices(service.getCategoryId()));
		return mv;
	}
	
	@RequestMapping(value = "/product/{id}")
	public ModelAndView product(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("/clientViews/page");
		mv.addObject("title", "Product");
		mv.addObject("userClickProduct", true);
		Product product = productDAO.get(id);
		mv.addObject("product", product);
		mv.addObject("category", categoryDAO.get(product.getCategoryId()));
		mv.addObject("products", productDAO.listCategoryActiveProducts(product.getCategoryId()));
		return mv;
	}
	
	@RequestMapping(value = "/client/{id}")
	public ModelAndView client(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("/clientViews/page");
		mv.addObject("title", "Client");
		mv.addObject("userClickClient", true);
		Client client = clientDAO.get(id);
		mv.addObject("client", client);
		return mv;
	}
	
}
