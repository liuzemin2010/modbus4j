package com.net4iot.oss.infra.annotation;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.net4iot.oss.infra.orm.PropertyFilter;
import com.net4iot.oss.infra.utils.Constants;       

/**
 *<pre>
 * 作用:切点类
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年4月17日
 * @see     
 * @since  
 */
@Aspect    
@Component    
public class TimeAspect {
	 
    //Service层切点    
    @Pointcut("@annotation(com.net4iot.oss.infra.annotation.TimeAnnotation)")    
     public  void serviceAspect() {    
    }    
    
    //Controller层切点    
    @Pointcut("@annotation(com.net4iot.oss.infra.annotation.TimeAnnotation)")    
     public  void controllerAspect() {    
    }    
    
    /**  
     * 前置通知 用于拦截Controller层查询条件为空  
     *  
     * @param joinPoint 切点  
     */    
    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) {    
    
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        List<PropertyFilter> filters = PropertyFilter
				.buildFromHttpRequest(request);
        request.setAttribute("filters", filters);
        /*没有筛选条件时初始化查询时间*/
        if(filters.size()==0){
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			Date start = new Date(now.getTime()-Constants.INITTIME);
			String startstr = sdf.format(start);
			String end = sdf.format(now);
			
			filters.add(new PropertyFilter("GED_createTime", startstr));
			request.setAttribute("start", startstr);
		/*	request.setAttribute("end",end);
			filters.add(new PropertyFilter("LED_createTime", end));*/
		}
    }  
    /**  
     * 异常通知   
     *  
     * @param joinPoint  
     * @param e  
     */    
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {    
        //do noting
    }    
    
    
    /**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMthodDescription(JoinPoint joinPoint)    
             throws Exception {    
       
         return null;    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(TimeAnnotation. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    

}
