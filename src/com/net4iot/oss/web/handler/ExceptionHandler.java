package com.net4iot.oss.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *<pre>
 * 作用:全局异常处理类
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2016年12月7日
 * @see     
 * @since  
 */

public class ExceptionHandler implements HandlerExceptionResolver{

	private static final Logger log = Logger.getLogger("ExceptionHandler");
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
	        //String url = WebUtils.getPathWithinApplication(request);  
	        //log.error("controller error.url=" + url, ex); 
		  log.error(handler);
		  StackTraceElement[] e= ex.getStackTrace();
		  //ex.printStackTrace();
		  String message = ex.toString(); 
		  for(int i=0;i<e.length;i++){
			  message = message +"\n        "+ e[i];
		  }
		 log.error(message+"\n");
		  return new ModelAndView("common/error");
	}

}
