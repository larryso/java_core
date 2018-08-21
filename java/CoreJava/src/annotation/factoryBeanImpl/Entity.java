package annotation.factoryBeanImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Entity Annotation
 * 
 * @author dsong
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Entity {
	// Entity name
	public String name() default "";

	// if is lazy load
	public boolean isLazyLoad() default true;
}
