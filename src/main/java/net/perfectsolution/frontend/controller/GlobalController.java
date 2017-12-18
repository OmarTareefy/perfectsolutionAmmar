package net.perfectsolution.frontend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.perfectsolution.backend.dao.CategoryDAO;
import net.perfectsolution.backend.dao.ClientDAO;
import net.perfectsolution.backend.dao.ConfigurationDAO;
import net.perfectsolution.backend.dao.ProductDAO;
import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.Category;
import net.perfectsolution.backend.dto.Client;
import net.perfectsolution.backend.dto.Configuration;
import net.perfectsolution.backend.dto.Product;
import net.perfectsolution.backend.dto.Service;

@ControllerAdvice
public class GlobalController {
	
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
	
	/*
	@Autowired
	WeatherProvider weatherProvider;
	 */
	
	@ModelAttribute("configuration")
	public Configuration getConfiguration(){		
		return configurationDAO.get(1);
	}

	
	@ModelAttribute("clients")
	public List<Client> getClients(){
		return clientDAO.list();
	}
	
	@ModelAttribute("activeClients")
	public List<Client> getActiveClients(){
		return clientDAO.listActiveClients();
	}
	
	@ModelAttribute("productCategoriesMap")
	public Map getProductCategoriesMap(){
		
		Map <Category, List<Product>> productCategoriesMap = new TreeMap <Category, List<Product>>();
		List<Category> list = categoryDAO.list(1);
		
		for(Category productCategory : list){
			productCategoriesMap.put(productCategory, productDAO.listCategoryProducts(productCategory.getId()));
		}
		
		return productCategoriesMap;
	}
	
	@ModelAttribute("activeProductCategoriesMap")
	public Map getActiveProductCategoriesMap(){
		
		Map <Category, List<Product>> activeProductCategoriesMap = new TreeMap <Category, List<Product>>();
		List<Category> list = categoryDAO.listActiveCategories(1);
		
		for(Category activeProductCategory : list){
			activeProductCategoriesMap.put(activeProductCategory, productDAO.listCategoryActiveProducts(activeProductCategory.getId()));
		}
		
		return activeProductCategoriesMap;
	}
	
	
	
	
	@ModelAttribute("serviceCategoriesMap")
	public Map getServiceCategoriesMap(){
		
		Map <Category, List<Service>> serviceCategoriesMap = new TreeMap <Category, List<Service>>();
		List<Category> list = categoryDAO.list(2);
		
		for(Category serviceCategory : list){
			serviceCategoriesMap.put(serviceCategory, serviceDAO.listCategoryServices(serviceCategory.getId()));
		}
		
		return serviceCategoriesMap;
	}
	
	@ModelAttribute("activeServiceCategoriesMap")
	public Map getActiveServiceCategoriesMap(){
		
		Map <Category, List<Service>> activeServiceCategoriesMap = new TreeMap <Category, List<Service>>();
		List<Category> list = categoryDAO.listActiveCategories(2);
		
		for(Category activeServiceCategory : list){
			activeServiceCategoriesMap.put(activeServiceCategory, serviceDAO.listCategoryActiveServices(activeServiceCategory.getId()));
		}
		
		return activeServiceCategoriesMap;
	}
	

	/*
	@ModelAttribute("weatherDesc")
	public String weatherDesc(){
		return weatherProvider.getWeatherDesc();
	}*/
}
