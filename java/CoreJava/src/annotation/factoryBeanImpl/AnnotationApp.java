package annotation.factoryBeanImpl;

import annotation.factoryBeanImpl.bean.User;
import annotation.factoryBeanImpl.bean.factory.BeanFactory;

public class AnnotationApp {
	public static void main(String[] args) throws Exception{
		BeanFactory factory = new BeanFactory();
		factory.init();
		User user = (User)factory.getBean("user");
		System.out.println(user.getName());
	}

}
