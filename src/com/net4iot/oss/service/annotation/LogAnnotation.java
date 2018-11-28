package com.net4iot.oss.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
	
	/***
	 * 日志名称
	 * @return
	 */
	String value() default "";
	/***
	 * 日志内容
	 * @return
	 */
	String context() default "";
	
	/***
	 * 如果有request  则为request参数名称
	 * @return
	 */
	String[] paramNames() default {};
}
