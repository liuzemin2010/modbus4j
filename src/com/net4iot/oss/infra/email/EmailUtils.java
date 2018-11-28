package com.net4iot.oss.infra.email;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * <pre>
 * 作用:发送邮件
 * 注意:
 * 其他:
 * </pre>
 *
 * @author yanglijuan
 * @version 1.0, 2017年11月30日
 * @see
 * @since
 */
@Component("emailUtils")
public class EmailUtils implements ApplicationContextAware, DisposableBean {

	/**
	 * 发件人标识
	 */
	public final static String FROM = "Chenwentao";
  
	private static JavaMailSender mailSender;

	private static FreeMarkerConfigurer freeMarker;

	private static Configuration cfg = new Configuration();

	public static String sendMail(String from, String[] to, String subject,
			String content) {
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(to); // 接收人
			mail.setFrom(from); // 发送人
			mail.setSubject(subject);// 标题
			mail.setText(content);
			mailSender.send(mail);
			return "success";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "fail：" + ex.getMessage();
		}
	}

	/**
	 * @param from
	 *            发件人
	 * @param to
	 *            接受人
	 * @param subject
	 *            主题
	 * @param templateName
	 *            模板名称
	 * @param datas
	 *            数据
	 */
	public static void sendMail(String from, String to, String subject,
			String templateName, Map<String, String> datas) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(to.split(",")); // 接收人
		mail.setFrom(from); // 发送人
		mail.setSubject(subject);// 标题
		// 嵌入ftl模版
		cfg.setClassForTemplateLoading(EmailUtils.class, "/mail");
		String content = getMailText(templateName, datas);
		mail.setText(content);
		mailSender.send(mail);
	}

	/**
	 * 发送html邮件，可以带附件
	 * 
	 * @param from
	 *            发件人
	 * @param to
	 *            接受人
	 * @param subject
	 *            主题
	 * @param templateName
	 *            模板名称
	 * @param datas
	 *            数据
	 */
	public static void sendMailMini(final String from, final String to,
			final String subject, String templateName, Map<String, String> datas) {
		// 获得html内容
		cfg.setClassForTemplateLoading(EmailUtils.class, "/mail");
		final String content = getMailText(templateName, datas);

		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
			helper.setTo(to.split(","));
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			// Logs.error("发送邮件出现错误" + e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 根据模板和内容返回text内容
	 * 
	 * @param templateName
	 * @param datas
	 * @return
	 */
	private static String getMailText(String templateName,
			Map<String, String> datas) {
		Template tpl;
		try {
			tpl = freeMarker.getConfiguration().getTemplate(templateName);
			return FreeMarkerTemplateUtils
					.processTemplateIntoString(tpl, datas);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (TemplateException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		mailSender = applicationContext.getBean(JavaMailSender.class);
		freeMarker = applicationContext.getBean(FreeMarkerConfigurer.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		mailSender = null;
		freeMarker = null;
	}
}
