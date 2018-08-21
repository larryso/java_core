package annotation.anno;

import java.lang.annotation.*;

/**
 * 
 * @author dsong
 * 
 * Inherited annotation could be inherited by sub class
 *
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyInheritedAnnotation {
	public String name();
}
