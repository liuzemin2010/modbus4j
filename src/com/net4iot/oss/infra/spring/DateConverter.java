package com.net4iot.oss.infra.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @author chenwentao
 * @version 0.1
 * @date 2014-10-17
 * @fucntion <pre>
 * Spring 日期转换类
 * </pre>
 * 
 */
public class DateConverter implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
}
