package com.careercitydashboard.util;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SqlPrintOut {
	
	 @Value("${spring.queries.user-query}")
	  	private static String userRole;
	
	public static void main(String[] args) {
	      
	      System.out.println(userRole);
	}    

}
