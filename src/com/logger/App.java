package com.logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.log4j.Logger;


public class App {

	static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {

		logger.debug("This is debug message");

		// info() method is use to write message into log file .
		logger.info("This is info message");

		// warn() method is use to write warning message into log file .
		logger.warn("This is warn message");

		// fatal() method is use to write fatal error into log file.
		logger.fatal("This is fatal message");

		// error() method is use to write error like exception, or logical error into
		// log file.
		logger.error("This is error message");

		System.out.println("Logic executed successfully....");

		// try catch example 
		try {

			FileReader fileReader = new FileReader("/out.py");

		} catch (FileNotFoundException e) {
			logger.error("Getting exception:", e);
		}

	}

}