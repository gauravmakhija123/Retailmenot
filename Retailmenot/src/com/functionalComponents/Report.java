package com.functionalComponents;

import org.testng.Reporter;

public class Report {
	   public static void getMessage(String message) {
	        Reporter.log((String)message);
	        System.out.println(message);
	    }
}


