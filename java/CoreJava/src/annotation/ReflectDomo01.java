package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectDomo01 {
	public static void main(String[] args)throws Exception{
		Class<?> c = null;
		c =Class.forName("annotation.SimpleBeanOne") ;
		Method m = c.getMethod("toString");
		Annotation ann[] = m.getAnnotations();
		for(Annotation a : ann){
			System.out.println(a);
		}
	}

}
