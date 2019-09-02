package com.careercitydashboard.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	
	/*localpath*/
//	private static String UPLOADER_FOLDER = "C://things//";

	
	/*serverpath-dev*/
	private static String UPLOADER_FOLDER = "//opt/tomcat/webapps/ImageRepo//";
	
	// Production Environment
	private static final String prod_host = "35.185.222.6";
	
	// Development Environment
	private static final String dev_host = "35.197.38.49";
	@GetMapping("/uploadpage")
	public String gotouploadpage() {
		return "imagefileupload";
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("warning", "Please Select a file to upload");
			return "redirect:/uploadStatus";
		}
		try {
			byte[] bytes =file.getBytes();
			Path path = Paths.get(UPLOADER_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
			String url = "https://"+prod_host+"/ImageRepo/" + file.getOriginalFilename();
			redirectAttributes.addFlashAttribute("message",
                    url);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "redirect:/uploadStatus";
	}
	
	
	
	@PostMapping("/uploadImage")
	public String singeImageUpload(MultipartFile file) {
		
		File directory = new File(UPLOADER_FOLDER);
		
		if(!directory.exists()) {
			directory.mkdir();
		}

		String url ="";
		try {
			byte[] bytes =file.getBytes();
			Path path = Paths.get(UPLOADER_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
//			url =  "https://"+prod_host+"/ImageRepo/" + file.getOriginalFilename();
			url =  "http://"+dev_host+"/ImageRepo/" + file.getOriginalFilename();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		return url;
	}
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
	
}
