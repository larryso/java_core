package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SimpleTest {
	/*
	 * 获取日志记录器，这个记录器将负责控制日志信息。其语法为：
       public static Logger getLogger( String name)
	 */
	private static Logger logger = Logger.getLogger(SimpleTest.class.getName());  

	public static void main(String[] args){
		
		logger.debug("This is simple log test--debug");//插入记录信息
		logger.info("This is simple log test--info");
		logger.error("This is simple log test--error");
		logger.warn("This is simple log test--warn");
	}

}
