package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SimpleTest {
	/*
	 * ��ȡ��־��¼���������¼�������������־��Ϣ�����﷨Ϊ��
       public static Logger getLogger( String name)
	 */
	private static Logger logger = Logger.getLogger(SimpleTest.class.getName());  

	public static void main(String[] args){
		
		logger.debug("This is simple log test--debug");//�����¼��Ϣ
		logger.info("This is simple log test--info");
		logger.error("This is simple log test--error");
		logger.warn("This is simple log test--warn");
	}

}
