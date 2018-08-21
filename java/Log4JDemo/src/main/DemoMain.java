package main;

import java.io.File;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;

import common.MyLogger;

public class DemoMain {
	//load log4j.properties when application startup
	{
		String classPath = this.getClass().getClassLoader().getResource("").getFile();
		File classFileDir = new File(classPath);
		if(classFileDir.isDirectory()){
			String propFilePath = classFileDir.getParent()+File.separator+"conf";
			//String log4jFilePath = propFilePath + File.separator+"log4j.properties";
			PropertyConfigurator.configure ( propFilePath+File.separator+"mylogger.properties");
		}
		
	}
	public static void main(String[] args){
		DemoMain mail = new DemoMain();
		MyLogger.info(DemoMain.class.getName(), "from DemoMain--info");
		MyLogger.debug(DemoMain.class.getName(), "from DemoMain--debug");
		MyLogger.warn(DemoMain.class.getName(), "from DemoMain--warn");
		MyLogger.error(DemoMain.class.getName(), "from DemoMain--error");
	}

}
