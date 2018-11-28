package com.net4iot.oss.infra.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;   
/**
 *<pre>
 * 作用:自定义注解 拦截Controller
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年4月17日
 * @see     
 * @since  
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public @interface TimeAnnotation {
	    String description()  default "";    

}
