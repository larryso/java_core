package annotation.anno;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
/**
 * 
 * @author dsong
 *
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface TargetTest {

}
