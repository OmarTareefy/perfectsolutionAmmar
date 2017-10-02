package net.perfectsolution.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.perfectsolution.backend.dao.ServiceDAO;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@ModelAttribute("services")
	public List getServices(){
		return serviceDAO.listActiveServices();
	}
}
