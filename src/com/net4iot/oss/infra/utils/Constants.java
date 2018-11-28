/**
 * 
 */
package com.net4iot.oss.infra.utils;

import java.util.HashMap;
import java.util.Map;

import com.net4iot.oss.infra.config.Config;

/**
 * <pre>
 * 静态常量类
 * </pre>
 * 
 * @author chenwentao
 * 
 */
public abstract class Constants {

	public static final String TTN_OTAA_URL = String.format(
			"http://%s:%s/api/register/otaa",
			Config.getProperty(Config.TTN_IP),
			Config.getProperty(Config.TTN_PORT));
	
//	public static final String NETMASTER_OTAA_URL = String.format("http://%s:%s/lpwan/admin/command/register/otaa", Config.getProperty(Config.NETMASTER_IP),
//			Config.getProperty(Config.NETMASTER_PORT));
	public static final String DM_QUERYALLCOMPANY = String.format(Config.getProperty(Config.DM_QUERYALLCOMPANY));


    public static final String USR_USERNAME = String.format(Config.getProperty(Config.USR_USERNAME));
    public static final String USE_PASSWORD = String.format(Config.getProperty(Config.USE_PASSWORD));
    public static final String USE_DEVICE_ID = String.format(Config.getProperty(Config.USE_DEVICE_ID));

    public static final String EZGXY_WDMS_COMPANY_ID = String.format(Config.getProperty(Config.EZGXY_WDMS_COMPANY_ID));
    public static final String EZGXY_COMPANY_ID = String.format(Config.getProperty(Config.EZGXY_COMPANY_ID));

	public static final String DM_QUERYALLAPPEUI= String.format(
			Config.getProperty(Config.DM_QUERYALLAPPEUI));

	public static final String DM_QUERYAPPEUI= String.format(
			Config.getProperty(Config.DM_QUERYAPPEUI));
	public static final String TTN_ABP_URL = String.format(
			"http://%s:%s/api/register/abp", Config.getProperty(Config.TTN_IP),
			Config.getProperty(Config.TTN_PORT));

	public static final String TTN_DOWNLINK = String.format(
			"http://%s:%s/api/register/downlink",
			Config.getProperty(Config.TTN_IP),
			Config.getProperty(Config.TTN_PORT));

	public static final Integer ABP_Register = 0;

	public static final Integer OTAA_Register = 1;
	
	/**
	 * payloadType 0表示采用字符串编码，1表示采用16进制编码  2表示二进制
	 */
	public static final Integer PAY_LOAD_TYPE_STRING = 0;
	
	public static final Integer PAY_LOAD_TYPE_HEX = 1;
	
	public static final Integer PAY_LOAD_TYPE_BINARY = 2;
	
	/**
	 * 0未推送 1已推送
	 * 
	 */
	public static final Integer PUSH_FLAG_NO = 0;
	
	public static final Integer PUSH_FLAG_YES = 1;
	
	
	/**
	 * DataType  0心跳包， 1 设备数据
	 */
	public static final Integer DATA_TYPE_HEART_BEAT = 0;
	
	public static final Integer DATA_TYPE_DEVICE_DATA = 1;
	
	
	
	public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
			+ ".eyJhdWQiOiJUVE4tSEFORExFUi0xIiwiaXNzIjoiVGhlVGhpbmdzVGhlTmV0d29yayIsInN1YiI6IjAxMDIwMzA0MDUwNjA3MDgifQ"
			+ ".zMHNXAVgQj672lwwDVmfYshpMvPwm6A8oNWJ7teGS2A";

	public static final String FTP_ADDRESS = Config.getProperty(Config.FTP_URL);
	public static final String FTP_PORT = Config.getProperty(Config.FTP_PORT);
	public static final String FTP_USER = Config.getProperty(Config.FTP_NAME);
	public static final String FTP_PSD = Config
			.getProperty(Config.FTP_PASSWORD);
	public static final String FTP_FILE = Config
			.getProperty(Config.FTP_FILE_SAVEPATH);
	public static final String COMPANY_URL=Config.getProperty(Config.DM_CHECKCOMPANY_URL);
	public static final String REGISTER_URL=Config.getProperty(Config.DM_REGISTER_URL);
	public static final String PUSH_DEVICE_ANALYSIS_DATA_URL=Config.getProperty(Config.DM_PUSH_DEVICE_ANALYSIS_DATA_URL);
	public static final String PUSH_DEVICE_ANALYSIS_DATA_TO_API_ADMIN_URL=Config.getProperty(Config.PUSH_DEVICE_ANALYSIS_DATA_TO_API_ADMIN_URL);
	public static final String QUERY_ALL_COMPANY_BY_PAGE=Config.getProperty(Config.QUERY_ALL_COMPANY_BY_PAGE);
	public static final String QUERY_ALL_COMPANY_NO_PAGE=Config.getProperty(Config.QUERY_ALL_COMPANY_NO_PAGE);
	public static final String DM_PUSH_NETWORK_MANAGEMENT_DATA_URL=Config.getProperty(Config.DM_PUSH_NETWORK_MANAGEMENT_DATA_URL);
	public static final String NETWORK_MANAGEMENT_TOKEN=Config.getProperty(Config.NETWORK_MANAGEMENT_TOKEN);
	public static final String CURRENTUSER = "dmuser";
	public static final Long INITTIME = 7 * 24 * 60 * 60 * 1000l;

	public static final Integer AP_STATUS = 0;

	public static final Integer SN_STATUS = 1;

	public static final int ONLINE_STATUS = 0;

	public static final int OFFLINE_STATUS = 1;

	public static final Integer UNTREATED_STATUS = 0;

	public static final Integer DISPOSE_STATUS = 1;

	public static final Integer SUCCESS_STATUS = 0;

	public static final Integer FAIL_STATUS = 1;

	public static final Map<Integer, String> DEVICES_TYPE = new HashMap<Integer, String>();

	public interface Ap {
		// 在线为0
		static int NETSTATE_ONLINE = 0;

		// 离线为1
		static int NETSTATE_OFFLINE = 1;
	}
	public interface Device {
		// 网络在线
		static int NETSTATE_ONLINE = 0;

		// 网络掉线先
		static int NETSTATE_OFFLINE = 1;

		// 设备状态正常
		static int DEVICESTATE_NORMAL = 0;

		// 这边状态异常
		static int DEVICESTATE_ABNORMAL = 1;
	}
	/**
	 *<pre>
	 * 作用:告警类型
	 *</pre>
	 *
	 * @author  yanglijuan
	 * @version 1.0, 2017年12月8日
	 * @see     
	 * @since
	 */
	public interface AlarmType {
		// 离线报警
		static int NETSTATUS = 0;

		// 设备状态报警
		static int ALARMSTATUS = 1;
	}

	public interface PushData {
		// 未发送 0
		static int DATA_UNSENT = 0;

		// 已发送 1
		static int DATA_SENT = 1;
	}

	public interface RuleState {
		// 开启 0
		static int OPEN = 0;

		// 关闭 1
		static int CLOSE = 1;
	}

	// 故障类型,0表示属性错误，1表示事件错误
	public interface LogDeviceHistoryFaultType {
		// 0 属性错误
		static int PROPERTY_FAULT = 0;

		// 事件错误 1
		static int EVENT_FAUL = 1;
	}

	public interface Alarm {

		interface State {
			/**
			 * 0 表示开
			 */
			static int ON = 0;

			/**
			 * 1 表示关
			 */
			static int OFF = 1;
		}

		interface LEVEL {
			/**
			 * 0 表示低
			 */
			static int LOW = 0;

			/**
			 * 1 表示中
			 */
			static int MIDDLE = 1;

			/**
			 * 2 表示高
			 */
			static int HIGH = 2;
		}

		interface NOTICE_TYPE {
			/**
			 * 0 表示邮件通知
			 */
			static int EMAIL = 0;

			/**
			 * 1 表示手机通知
			 */
			static int MOBILE = 1;
		}

		interface RESULT_TYPE {
			/**
			 * 0 表示未处理
			 */
			static int UNTREATED = 0;

			/**
			 * 1 表示处理中
			 */
			static int IN_PROGRESS = 1;

			/**
			 * 2 表示处理完毕
			 */
			static int DONE = 2;

			/**
			 * 3 表示无法处理
			 */
			static int COULD_NOT_HANDLE = 3;
		}
	}

	public static String getAlarmLevel(Integer level) {
		if (level == Alarm.LEVEL.LOW) {
			return "低-一般";
		}

		if (level == Alarm.LEVEL.MIDDLE) {
			return "中-紧急";
		}

		if (level == Alarm.LEVEL.HIGH) {
			return "高-重要";
		}

		return "未知等级";
	}

	public static String displayProperty(Integer deviceType,
			String propertyName, String value) {
		String key = deviceType + ":" + propertyName;

		if ("1:openTimes".equals(key)) {
			String pre = "";
			return pre + value;
		}

		if ("2:state".equals(key)) {
			String pre = "";
			if ("0".equals(value)) {
				return pre + "关门";
			}

			if ("1".equals(value)) {
				return pre + "开门";
			}

			return value;
		}

		if ("3:state".equals(key)) {
			String pre = "";
			if ("0".equals(value)) {
				return pre + "关门";
			}

			if ("1".equals(value)) {
				return pre + "开门";
			}

			return value;
		}

		if ("5:elecValue".equals(key)) {
			String pre = "";
			return pre + value + "(A)";
		}

		if ("5:voltage".equals(key)) {
			String pre = "";
			return pre + value;
		}

		if ("7:temperatureValue".equals(key)) {
			String pre = "";
			return pre + value + "(℃)";
		}

		if ("7:humidity".equals(key)) {
			String pre = "";
			return pre + value + "(%RH)";
		}

		if ("8:pressureValue".equals(key)) {
			String pre = "";
			try {
				value = String.format("%.2f", Double.valueOf(value) * 1000);
			} catch (Exception ex) {
				value = "异常数据,请检查";
			}
			return pre + value + "(KPa)";
		}

		if ("9:waterLevel".equals(key)) {
			String pre = "";
			if ("0".equals(value)) {
				return pre + "无水";
			}

			if ("1".equals(value)) {
				return pre + "有水";
			}

			return value;
		}

		if ("11:waterFlow".equals(key)) {
			String pre = "";
			return pre + value + "(吨)";
		}

		if ("12:elecValue".equals(key)) {
			String pre = "";
			return pre + value + "(A)";
		}

		if ("17:apValue".equals(key)) {
			String pre = "";
			return pre + value + "(MPa)";
		}

		// 电压 V A KWH
		if ("20:UA".equals(key)) {
			String pre = "";
			return pre + value + "(V)";
		}

		if ("20:UB".equals(key)) {
			String pre = "";
			return pre + value + "(V)";
		}

		if ("20:UC".equals(key)) {
			String pre = "";
			return pre + value + "(V)";
		}

		if ("20:IA".equals(key)) {
			String pre = "";
			return pre + value + "(A)";
		}

		if ("20:IB".equals(key)) {
			String pre = "";
			return pre + value + "(A)";
		}

		if ("20:IC".equals(key)) {
			String pre = "";
			return pre + value + "(A)";
		}

		if ("20:energy".equals(key)) {
			String pre = "";
			return pre + value + "(KWH)";
		}

		if ("21:state".equals(key)) {
			if ("00".equals(value)) {
				return "降锁";
			}

			if ("01".equals(value)) {
				return "升锁";
			}

			if ("99".equals(value)) {
				return "故障";
			}
		}

		if ("22:state".equals(key)) {
			if ("EXISTS".equals(value)) {
				return "有车";
			}

			if ("UNEXISTS".equals(value)) {
				return "无车";
			}

			if ("FAULT".equals(value)) {
				return "故障";
			}
		}

		if ("24:floor".equals(key)) {
			return value + "层";
		}

		if ("24:direction".equals(key)) {
			if ("0".equals(value)) {
				return "等客";
			}

			if ("1".equals(value)) {
				return "上行";
			}

			if ("2".equals(value)) {
				return "下行";
			}

			return value;
		}

		if ("24:model".equals(key)) {
			if ("0".equals(value)) {
				return "正常";
			}

			if ("1".equals(value)) {
				return "锁梯";
			}

			if ("2".equals(value)) {
				return "消防";
			}

			if ("3".equals(value)) {
				return "检修";
			}

			if ("4".equals(value)) {
				return "司机";
			}

			if ("5".equals(value)) {
				return "超载";
			}

			if ("6".equals(value)) {
				return "VIP";
			}

			if ("7".equals(value)) {
				return "层间停梯";
			}

			if ("8".equals(value)) {
				return "层间停梯困人";
			}

			if ("9".equals(value)) {
				return "冒顶困人";
			}

			if ("10".equals(value)) {
				return "墩底困人";
			}

			if ("11".equals(value)) {
				return "冒顶";
			}

			if ("12".equals(value)) {
				return "墩底";
			}

			if ("13".equals(value)) {
				return "反复开关门";
			}

			if ("14".equals(value)) {
				return "紧急按钮";
			}

			if ("15".equals(value)) {
				return "预留";
			}

			if ("16".equals(value)) {
				return "开门走梯";
			}

			if ("17".equals(value)) {
				return "运行超时";
			}

			if ("18".equals(value)) {
				return "开门走梯困人";
			}

			if ("19".equals(value)) {
				return "运行超时困人";
			}

			if ("20".equals(value)) {
				return "长时间开门";
			}

			// 金数字电梯协议
			if ("0000".equals(value)) {
				return "正常";
			}

			if ("4003".equals(value)) {
				return "冲顶";
			}

			if ("4004".equals(value)) {
				return "蹲底";
			}

			if ("4005".equals(value)) {
				return "开门走梯";
			}

			if ("4009".equals(value)) {
				return "非平层区域停梯";
			}

			return value;
		}

		if ("26:elecLevel".equals(key)) {

			if ("0".equals(value)) {
				return "关机";
			}
			if ("1".equals(value)) {
				return "正常";
			}
		}

		if ("28:voltage".equals(key)) {
			return value + "(V)";
		}

		if ("28:current".equals(key)) {
			return value + "(A)";
		}

		if ("29:windSpeed".equals(key)) {
			String pre = "风速:";
			return pre + value + "(m/s)";
		}

		if ("29:windDirection".equals(key)) {
			String pre = "风向:";
			return pre + value + "(°)";
		}

		if ("29:temperature".equals(key)) {
			String pre = "温度:";
			return pre + value + "(℃)";
		}

		if ("29:humidity".equals(key)) {
			String pre = "湿度:";
			return pre + value + "(%RH)";
		}

		if ("29:pile".equals(key)) {
			String pre = "电堆:";
			return pre + value + "(W/m2)";
		}

		if ("29:reflectedRadiation".equals(key)) {
			String pre = "反射辐射:";
			return pre + value + "(W/m2)";
		}

		if ("29:directRadiation".equals(key)) {
			String pre = "直接辐射:";
			return pre + value + "(W/m2)";
		}

		if ("29:scatteredRadiation".equals(key)) {
			String pre = "散射辐射:";
			return pre + value + "(W/m2)";
		}

		if ("31:temperatureValue".equals(key)) {
			String pre = "";
			return pre + value + "(℃)";
		}

		if ("32:state".equals(key)) {

			if ("0".equals(value)) {
				return "正常";
			}

			if ("1".equals(value)) {
				return "报警";
			}
		}

		if ("33:formaldehyde".equals(key)) {
			String pre = "甲醛含量";
			return pre + value + "(mg/m3)";
		}

		if ("33:pm2.5".equals(key)) {
			String pre = "PM2.5含量";
			return pre + value + "(ug/m3)";
		}

		return value;
	}

}
