package com.net4iot.oss.infra.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DataC implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(arg0);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
