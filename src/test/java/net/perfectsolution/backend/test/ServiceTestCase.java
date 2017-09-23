package net.perfectsolution.backend.test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.Service;

public class ServiceTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ServiceDAO serviceDAO;
	private Service service;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.perfectsolution.backend");
		context.refresh();
		serviceDAO = (ServiceDAO)context.getBean("serviceDAO");
	}
	
	@Test
	public void testlistActiveServices(){
		assertEquals("Error when getting the list of Active Services", 
				2, serviceDAO.listActiveServices().size());
	}
	
}
