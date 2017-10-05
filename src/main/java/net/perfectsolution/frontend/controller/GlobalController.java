package net.perfectsolution.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.frontend.restfulConsumer.WeatherProvider;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@Autowired
	WeatherProvider weatherProvider;
	
	@ModelAttribute("services")
	public List getServices(){
		return serviceDAO.listActiveServices();
	}

	/*
	@ModelAttribute("weatherDesc")
	public String weatherDesc(){
		return weatherProvider.getWeatherDesc();
	}*/
}
