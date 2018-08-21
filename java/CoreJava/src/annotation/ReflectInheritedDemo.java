package annotation;

import java.lang.annotation.Annotation;

import annotation.anno.MyInheritedAnnotation;
/**
 *  use @inherited defined annnotation, could be inherited by sub class
 * @author dsong
 *
 */
public class ReflectInheritedDemo {
	/*
	 * Class, Constructor, Field, Method, Package all implements AnnotationElement interface, and there are below
	 * methods included:
	 * getAnnotation(Class annotationType) //get a specific annotation type
	 * getAnnotations() //return all annotations
	 * getDecleartedAnnotations()
	 * isAnnotationPresent(Class<?>)
	 * 
	 */
	public static void main(String[] args) throws ClassNotFoundException{
		Class<?> c = null;
		c = Class.forName("annotation.Student");
		Annotation ann[] = c.getAnnotations();
		for(Annotation a: ann){
			System.out.println(a);
		}
		
		// get annoation content
		if(c.isAnnotationPresent(MyInheritedAnnotation.class)){
			MyInheritedAnnotation mdn = null;
			mdn = c.getAnnotation(MyInheritedAnnotation.class);
			String name = mdn.name();
			System.out.println("annotation content:"+ name);
		}
	}

}
