package com.net4iot.oss.infra.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

/**
 * <pre>
 * 作用:日历操作
 * 注意:
 * 其他:
 * </pre>
 *
 * @author yanglijuan
 * @version 1.0, 2016年11月14日
 * @see
 * @since
 */
public class CalendarUtil {
	/**
	 * 返回开始时间和结束时间之间的每个周期时间
	 * @param cycle
	 * @param staDate
	 * @param endDate
	 * @return
	 */

	public static List<String> getTimes(String cycle, Date staDate, Date endDate) {
		List<String> lDate = new ArrayList<String>();
		List<Date> ltime = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		cal.setTime(staDate);
		cal.add(Calendar.WEEK_OF_YEAR, -2);
		SimpleDateFormat sdf = null;
		boolean bContinue = true;
		while (bContinue) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			if ("hour".equals(cycle)) {
				cal.add(Calendar.HOUR_OF_DAY, 1);
			} else if ("day".equals(cycle)) {
				cal.add(Calendar.DAY_OF_MONTH, 1);
			} else if ("week".equals(cycle)) {
				cal.add(Calendar.WEEK_OF_YEAR, 1);
				sdf = new SimpleDateFormat("yyyy w");
			} else if ("month".equals(cycle)) {
				sdf = new SimpleDateFormat("yyyy-MM");
				cal.add(Calendar.MONTH, 1);
			}
			// 测试此日期是否在指定日期之后
			if (endDate.after(cal.getTime())) {
				Date date = cal.getTime();
				String timeString = sdf.format(date);
				lDate.add(timeString);
			} else {
				break;
			}
		}

		return lDate;

	}

}
