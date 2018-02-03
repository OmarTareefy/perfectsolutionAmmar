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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.perfectsolution.backend.dao.AboutDAO;
import net.perfectsolution.backend.dao.CategoryDAO;
import net.perfectsolution.backend.dao.ClientDAO;
import net.perfectsolution.backend.dao.ConfigurationDAO;
import net.perfectsolution.backend.dao.ProductDAO;
import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dao.SubscriberDAO;
import net.perfectsolution.backend.dto.About;
import net.perfectsolution.backend.dto.Category;
import net.perfectsolution.backend.dto.Client;
import net.perfectsolution.backend.dto.Configuration;
import net.perfectsolution.backend.dto.Product;
import net.perfectsolution.backend.dto.Service;
import net.perfectsolution.backend.utils.FileUploadUtility;
import net.perfectsolution.frontend.validator.ClientValidator;
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
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	SubscriberDAO subscriberDAO;
	
	@RequestMapping(value = {"/home","/","/index"}, method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		
		mv.addObject("title", "Home");		
		mv.addObject("userClickAdminHome", true);
		Configuration configuration = configurationDAO.get(1);
		mv.addObject("configuration", configuration);
		mv.addObject("subscribers", subscriberDAO.getSubscribersAsCSV());
		
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

	@RequestMapping(value = {"/service/cat/{categoryId}"}, method = RequestMethod.GET)
	public ModelAndView services(@PathVariable(value = "categoryId") int categoryId){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Service");
		mv.addObject("userClickAdminService", true);
		Service service = new Service();
		service.setActive(true);
		service.setCategoryId(categoryId);
		mv.addObject("service", service);

		return mv;
	}
	
	@RequestMapping(value = {"/service"}, method = RequestMethod.POST)
	public String handleServiceSubmit(@Valid @ModelAttribute("service") Service mService, BindingResult results, Model model, HttpServletRequest request){
		
		
		// handle image validation for new products
		if (mService.getId() == 0) {
			new ServiceValidator().validate(mService, results);
		} else {
			if (!mService.getFile().getOriginalFilename().equals("")) {
				new ServiceValidator().validate(mService, results);
			}
		}
		
		
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
		return "redirect:/manage/service/" + mService.getId() + "?operation=success";
		
	}

	
	@RequestMapping(value = {"/product/cat/{categoryId}"}, method = RequestMethod.GET)
	public ModelAndView products(@PathVariable(value = "categoryId") int categoryId){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Product");
		mv.addObject("userClickAdminProduct", true);
		Product product = new Product();
		product.setActive(true);
		product.setCategoryId(categoryId);
		mv.addObject("product", product);
		
		return mv;
	}

	@RequestMapping(value = {"/product"}, method = RequestMethod.POST)
	public String handleProductSubmit(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){
		
		
		// handle image validation for new products
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}

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
		
		return "redirect:/manage/product/" + mProduct.getId() + "?operation=success";
	}
	
	@RequestMapping(value = {"/service/{id}"}, method = RequestMethod.GET)
	public ModelAndView editService(@PathVariable int id, @RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Service");
		mv.addObject("userClickAdminService", true);
		
		Service service = serviceDAO.get(id);
		mv.addObject("service", service);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}

	@RequestMapping(value = {"/product/{id}"}, method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id, @RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Product");
		mv.addObject("userClickAdminProduct", true);
		
		Product product = productDAO.get(id);
		mv.addObject("product", product);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public void handleProductActivation(@PathVariable int id) {
		Product product = productDAO.get(id);

		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
	}


	@RequestMapping(value = "/service/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public void handleServiceActivation(@PathVariable int id) {
		Service service = serviceDAO.get(id);

		boolean isActive = service.isActive();
		service.setActive(!isActive);
		serviceDAO.update(service);
	}

	
	@RequestMapping(value = {"/productCategory"}, method = RequestMethod.GET)
	public ModelAndView productCategory(){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Product Category");
		mv.addObject("userClickAdminProductCategory", true);
		Category productCategory = new Category();
		productCategory.setActive(true);
		productCategory.setCategoryType(1);
		mv.addObject("productCategory", productCategory);
		return mv;
	}
	
	@RequestMapping(value = {"/serviceCategory"}, method = RequestMethod.GET)
	public ModelAndView serviceCategory(){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Service Category");
		mv.addObject("userClickAdminServiceCategory", true);
		Category serviceCategory = new Category();
		serviceCategory.setActive(true);
		serviceCategory.setCategoryType(2);
		mv.addObject("serviceCategory", serviceCategory);
		
		return mv;
	}
	
	@RequestMapping(value = {"/productCategory/{id}"}, method = RequestMethod.GET)
	public ModelAndView editProductCategory(@PathVariable int id, @RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Product Category");
		mv.addObject("userClickAdminProductCategory", true);
		
		Category productCategory = categoryDAO.get(id);
		mv.addObject("productCategory", productCategory);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}
	
	@RequestMapping(value = {"/serviceCategory/{id}"}, method = RequestMethod.GET)
	public ModelAndView editServiceCategory(@PathVariable int id, @RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Service Category");
		mv.addObject("userClickAdminServiceCategory", true);
		
		Category serviceCategory = categoryDAO.get(id);
		mv.addObject("serviceCategory", serviceCategory);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}

	@RequestMapping(value = {"/productCategory"}, method = RequestMethod.POST)
	public String handleProductCategorySubmit(@Valid @ModelAttribute("productCategory") Category mProductCategory, BindingResult results, Model model, HttpServletRequest request){
		
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "Product Category");		
			model.addAttribute("userClickAdminProductCategory", true);
			return "/adminViews/adminPage";
		}
		
		if (mProductCategory.getId() == 0) {
			categoryDAO.add(mProductCategory);
		} else {// update the product if id is not 0
			categoryDAO.update(mProductCategory);
		}
		
		return "redirect:/manage/productCategory/" + mProductCategory.getId() + "?operation=success";
		
	}

	
	@RequestMapping(value = {"/serviceCategory"}, method = RequestMethod.POST)
	public String handleServiceCategorySubmit(@Valid @ModelAttribute("serviceCategory") Category mServiceCategory, BindingResult results, Model model, HttpServletRequest request){
		
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "Service Category");		
			model.addAttribute("userClickAdminServiceCategory", true);
			return "/adminViews/adminPage";
		}
		
		if (mServiceCategory.getId() == 0) {
			categoryDAO.add(mServiceCategory);
		} else {// update the product if id is not 0
			categoryDAO.update(mServiceCategory);
		}
		
		return "redirect:/manage/serviceCategory/" + mServiceCategory.getId() + "?operation=success";
		
	}

	
	
	@RequestMapping(value = {"/client"}, method = RequestMethod.GET)
	public ModelAndView clients(){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Client");
		mv.addObject("userClickAdminClient", true);
		Client client = new Client();
		client.setActive(true);
		mv.addObject("client", client);
		
		
		return mv;
	}

	@RequestMapping(value = {"/client"}, method = RequestMethod.POST)
	public String handleClientSubmit(@Valid @ModelAttribute("client") Client mClient, BindingResult results, Model model, HttpServletRequest request){
				
		// handle image validation for new clients
		if (mClient.getId() == 0) {
			new ClientValidator().validate(mClient, results);
		} else {
			if (!mClient.getFile().getOriginalFilename().equals("")) {
				new ClientValidator().validate(mClient, results);
			}
		}
		
		//if there are any errors
		if (results.hasErrors()){
			model.addAttribute("title", "Client");		
			model.addAttribute("userClickAdminClient", true);
			return "/adminViews/adminPage";
		}
		
		if(!mClient.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mClient.getFile(), mClient.getCode());
		}
		
		if (mClient.getId() == 0) {
			clientDAO.add(mClient);
		} else {// update the product if id is not 0
			clientDAO.update(mClient);
		}
		
		return "redirect:/manage/client/" + mClient.getId() + "?operation=success";
	}

	@RequestMapping(value = {"/client/{id}"}, method = RequestMethod.GET)
	public ModelAndView editClient(@PathVariable int id, @RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("/adminViews/adminPage");
		mv.addObject("title", "Client");
		mv.addObject("userClickAdminClient", true);
		
		Client client = clientDAO.get(id);
		mv.addObject("client", client);
		
		if(operation!=null && !operation.isEmpty()){
			mv.addObject("message", operation);
		}
		
		return mv;
	}
	
}
