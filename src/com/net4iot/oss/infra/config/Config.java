/**
 * 
 * Copy Right@ chenwt
 */

package com.net4iot.oss.infra.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * <pre>
 * </pre>
 * 
 * @version 1.0, 2012-7-30
 * @author chenwentao
 * 
 */
@Configuration
@PropertySource("classpath:/properties/${spring.profiles.default}.properties")
public class Config {

	/**
	 * 上传图片保存路径
	 */
	public static final String UPLOAD_SAVEPATH = "savepath";

	/**
	 * 图片在url地址中访问的地址
	 */
	public static final String IMAGE_URL = "image.url";

	public static final String DOWNSTREAM_IP = "downstream.ip";

	public static final String DOWNSTREAM_PORT = "downstream.port";

	private static Environment environment;

	public static final String FTP_URL = "ftp.url";
	public static final String FTP_PORT = "ftp.port";
	public static final String FTP_NAME = "ftp.name";
	public static final String FTP_PASSWORD = "ftp.password";
	public static final String FTP_FILE_SAVEPATH = "ftp.savepath";

	public static final String FTP_IMAGE_SAVEPATH = "ftp.savepath";
	public static final String IMAGE_PREFIX = "image.prefix";

	public static final String TTN_IP = "ttn.ip";
	public static final String TTN_PORT = "ttn.port";
	
	public static final String NETMASTER_PORT="netmaster.port";
	
	public static final String DM_QUERYALLCOMPANY="dm.queryallcompany.url";


	public static final String USR_USERNAME="usr.username";
	public static final String USE_PASSWORD="usr.password";

	public static final String USE_DEVICE_ID="usr.device.id";

	public static final String EZGXY_WDMS_COMPANY_ID="ezgxy.wdms.company.id";
	public static final String EZGXY_COMPANY_ID="ezgxy.company.id";

	
	public static final String DM_QUERYALLAPPEUI="dm.queryallappEui.url";
	
	public static final String DM_QUERYAPPEUI="dm.queryappEui.url";
	public static final String DM_CHECKCOMPANY_URL="dm.checkcompany.url";
	public static final String DM_REGISTER_URL="dm.register.url";
	public static final String DM_PUSH_DEVICE_ANALYSIS_DATA_URL="dm.push.device.analysis.data.url";
	public static final String PUSH_DEVICE_ANALYSIS_DATA_TO_API_ADMIN_URL="dm.push.device.analysis.data.to.api.admin.url";
	public static final String QUERY_ALL_COMPANY_BY_PAGE="query.all.company.by.page";
	public static final String QUERY_ALL_COMPANY_NO_PAGE="query.all.company.no.page";
	public static final String DM_PUSH_NETWORK_MANAGEMENT_DATA_URL="dm.push.network.management.data.url";
	public static final String NETWORK_MANAGEMENT_TOKEN="network.management.token";
	
	
	@Inject
	public void setEnvironment(Environment environment) {
		Config.environment = environment;
	}

	public Config() {
	}

	public static String getProperty(String key) {
		return environment.getProperty(key);

	}

	public static Integer getPropertyInt(String key) {
		return Integer.valueOf(environment.getProperty(key));

	}

}
