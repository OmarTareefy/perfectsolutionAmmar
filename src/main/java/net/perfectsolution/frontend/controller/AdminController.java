package net.perfectsolution.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.perfectsolution.backend.dao.AboutDAO;
import net.perfectsolution.backend.dao.ConfigurationDAO;
import net.perfectsolution.backend.dao.ProductDAO;
import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.About;
import net.perfectsolution.backend.dto.Configuration;
import net.perfectsolution.backend.dto.Product;
import net.perfectsolution.backend.dto.Service;
import net.perfectsolution.backend.utils.FileUploadUtility;
import net.perfectsolution.frontend.validator.ProductValidator;
import net.perfectsolution.frontend.validator.ServiceValidator;

@Controller
@RequestMapping("/manage")
public class AdminController {
	
	@Autowired
	AboutDAO aboutDAO;
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@Autowired
	ProductDAO productDAO;

	@Autowired
	ConfigurationDAO configurationDAO;
	
	@RequestMapping(value = {"/home","/","/index"}, method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		
		mv.addObject("title", "Home");		
		mv.addObject("userClickAdminHome", true);
		mv.addObject("services", serviceDAO.list());
		mv.addObject("products", productDAO.list());
		Configuration configuration = configurationDAO.get(1);
		mv.addObject("configuration", configuration);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}

	
	@RequestMapping(value = {"/configuration"}, method = RequestMethod.POST)
	public String handleConfigurationSubmit(@Valid @ModelAttribute("configuration") Configuration mConfiguration, BindingResult results, Model model){
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "Home");		
			model.addAttribute("userClickAdminHome", true);
			return "/adminViews/adminPage";
		}
		mConfiguration.setId(1);
		if(configurationDAO.update(mConfiguration)){
			return "redirect:/manage/index?operation=success";
		}else{
			return "redirect:/manage/index?operation=failure";
		}
		
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

	@RequestMapping(value = {"/service"}, method = RequestMethod.GET)
	public ModelAndView services(@RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Service");
		mv.addObject("userClickAdminService", true);
		Service service = new Service();
		service.setActive(true);
		mv.addObject("service", service);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}
	
	@RequestMapping(value = {"/service"}, method = RequestMethod.POST)
	public String handleServiceSubmit(@Valid @ModelAttribute("service") Service mService, BindingResult results, Model model, HttpServletRequest request){
		
		
		new ServiceValidator().validate(mService, results);
		
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "Service");		
			model.addAttribute("userClickAdminService", true);
			return "/adminViews/adminPage";
		}
		
		if(!mService.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mService.getFile(), mService.getCode());
		}
		
		if (mService.getId() == 0) {
			serviceDAO.add(mService);
		} else {// update the product if id is not 0
			serviceDAO.update(mService);
		}
		
		return "redirect:/manage/service?operation=success";
		
	}

	
	@RequestMapping(value = {"/product"}, method = RequestMethod.GET)
	public ModelAndView products(@RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Product");
		mv.addObject("userClickAdminProduct", true);
		Product product = new Product();
		product.setActive(true);
		mv.addObject("product", product);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}

	@RequestMapping(value = {"/product"}, method = RequestMethod.POST)
	public String handleProductSubmit(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){
		
		
		new ProductValidator().validate(mProduct, results);
		
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "Product");		
			model.addAttribute("userClickAdminProduct", true);
			return "/adminViews/adminPage";
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {// update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		return "redirect:/manage/product?operation=success";
		
		
	}
	
	@RequestMapping(value = {"/service/{id}"}, method = RequestMethod.GET)
	public ModelAndView editService(@PathVariable int id){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Service");
		mv.addObject("userClickAdminService", true);
		
		Service service = serviceDAO.get(id);
		mv.addObject("service", service);
		return mv;
	}

	@RequestMapping(value = {"/product/{id}"}, method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Product");
		mv.addObject("userClickAdminProduct", true);
		
		Product product = productDAO.get(id);
		mv.addObject("product", product);
		return mv;
	}
	
	

}
