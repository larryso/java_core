package annotation.anno;
/**
 * 
 * @author dsong
 * define annotation with key and value
 */
public @interface MyDefaultAnnotationSimpleVal {
	public String key() default "key";
	public String value() default "value";
}
