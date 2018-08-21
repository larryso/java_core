package annotation.factoryBeanImpl;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;

/**
 * Entity Property annotation
 * 
 * @author dsong
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityProperty {
	public String value() default "";
}
