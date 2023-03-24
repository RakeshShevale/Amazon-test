package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JTest {

	private static Logger logger = LogManager.getLogger(Log4JTest.class);

	public static void main(String[] args) {
		System.out.println("Hello world ");

		logger.info("This is info msg");
		logger.error("This is error msg");
		
		logger.warn("This is warn msg");
		logger.fatal("This is fatal msg");
		
		System.out.println("Completed");

	}
}
