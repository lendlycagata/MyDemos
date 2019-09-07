package com.careercitydashboard.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowImageList {
	
public List<String> getAllImage() throws IOException {
		
		List<String> imagelist = new ArrayList<>();
		/*String url="C://things";*/
		String url="//opt/tomcat/webapps/ImageRepo//";
		
		String link="https://35.185.222.6/ImageRepo/";
		String locallink="C:\\things\\";
		File folder = new File(url);
		File [] listOfFiles = folder.listFiles();
		
		
		for(File file: listOfFiles ) {
			imagelist.add(link + file.getName()); 
			/*imagelist.add(locallink + file.getName());*/
			System.out.println("https://35.185.222.6/ImageRepo/" + file.getName());
		}
		
		return imagelist;
		
		
				
	}

}
