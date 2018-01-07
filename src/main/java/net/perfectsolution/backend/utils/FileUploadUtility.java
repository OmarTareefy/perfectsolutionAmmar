package net.perfectsolution.backend.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtility {
	
	private static final String ABS_PATH = "C:\\Users\\omar\\Desktop\\Spring\\Website\\perfectsolution\\src\\main\\webapp\\commonAssets\\adminAssets\\myImages\\";
	//private static final String ABS_PATH = "C:\\Users\\OKhalil\\git\\perfectsolution\\src\\main\\webapp\\commonAssets\\adminAssets\\myImages\\";
	private static String REAL_PATH = "";
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code){
		
		//This is how we get where the tomcat deployed the application
		REAL_PATH = request.getSession().getServletContext().getRealPath("/commonAssets/adminAssets/myImages/");
		/*
		 * to make sure all the directory exist
		 * if they are not, please create the directories 
		 */
		//if(!new File(ABS_PATH).exists()){
			//Create the directories
			//new File(ABS_PATH).mkdirs();
		//}
		
		if(!new File(REAL_PATH).exists()){
			//Create the directories
			new File(REAL_PATH).mkdirs();
		}
		
		try{
			//Server Upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//Project directory upload
			//file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}

}
