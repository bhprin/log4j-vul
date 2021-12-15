package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jVul {
	
	private static final Logger logger = LogManager.getLogger(Log4jVul.class);

	public static void main(String[] args) {
		
		String username = args[0];
		
		logger.error("** Username: " + username + "**");
	}
	


}
