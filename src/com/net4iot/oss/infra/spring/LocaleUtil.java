package com.net4iot.oss.infra.spring;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.net4iot.oss.infra.utils.CookieUtil;

/**
 * 
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author yanglijuan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class LocaleUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		applicationContext = arg0;
	}

	public static Object getBean(String id) {
		Object object = null;
		object = applicationContext.getBean(id);
		return object;
	}

	/**
	 * ��ȡ��Դ��Ϣ
	 * 
	 * @param request
	 * @param code
	 *            ��Դ��Ϣ���
	 * @param parms
	 * @return
	 */
	public static String getLocaleMessage(
			ApplicationContext applicationContext, HttpServletRequest request,
			String code, Object[] parms) {
		Cookie cookie = CookieUtil.getCookieByName(request, "lang");
		if (cookie != null) {
			String locale = cookie.getValue();
			String[] lstr = locale.split("_");
			return applicationContext.getMessage(code, parms, new Locale(
					lstr[0], lstr[1]));
		} else {
			return applicationContext.getMessage(code, parms,
					request.getLocale());
		}
	}
}
