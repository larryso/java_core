package common;

import org.apache.log4j.Logger;

import main.SimpleTest;

public class MyLogger {

	private static Logger getLogger(String clazz) {
		return Logger.getLogger(clazz);
	}
	public static void info(String clazz, String msg){
		Logger logger = getLogger(clazz);
		logger.info(msg);
	}
	public static void debug(String clazz, String msg){
		Logger logger = getLogger(clazz);
		logger.debug(msg);
	}
	public static void warn(String clazz, String msg){
		Logger logger = getLogger(clazz);
		logger.warn(msg);
	}
	public static void error(String clazz, String msg){
		Logger logger = getLogger(clazz);
		logger.error(msg);
	}

}
