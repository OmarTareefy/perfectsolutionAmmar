package net.perfectsolution.frontend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	//Whenever it is not able to find any handler for the request(404)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","404 Error Page");
		mv.addObject("error404", true);
		return mv;
		
	}
	
}
