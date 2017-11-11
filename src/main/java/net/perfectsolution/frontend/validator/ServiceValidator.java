package net.perfectsolution.frontend.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import net.perfectsolution.backend.dto.Service;


public class ServiceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Service.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//whether file has been selected or not
		Service service = (Service) target;
		if(service.getFile() == null || 
				service.getFile().getOriginalFilename().equals("")){
			
			errors.rejectValue("file", null, "Please select an image file to Upload!");
			return;
		}
		
		String fileContentType = service.getFile().getContentType();
		if(!(fileContentType.equals("image/jpeg") || 
			fileContentType.equals("image/png") ||
			fileContentType.equals("image/gif")) ){
			
			errors.rejectValue("file", null, "Please use only an image file to Upload");
			return;
		}


	}

}
