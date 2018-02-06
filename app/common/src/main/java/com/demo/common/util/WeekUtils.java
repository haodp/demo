package com.demo.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeekUtils {

	/**
	 * 获得一年的第几周的开始时间
	 *
	 * @param year
	 * @param weekNo
	 * @return
	 */
	public static String getStartDayOfWeekNo(int year, int weekNo) {
		Calendar cal = getCalendarFormYear(year);
		cal.set(Calendar.WEEK_OF_YEAR, weekNo);
		return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 获得一年的第几周的结束时间
	 *
	 * @param year
	 * @param weekNo
	 * @return
	 */
	public static String getEndDayOfWeekNo(int year, int weekNo) {
		Calendar cal = getCalendarFormYear(year);
		cal.set(Calendar.WEEK_OF_YEAR, weekNo);
		cal.add(Calendar.DAY_OF_WEEK, 6);
		return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
	}

	// 获取当前时间所在年的最大周数
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	// 获取当前时间所在年的周数
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获得一年的日历
	 *
	 * @param year
	 * @return
	 */
	private static Calendar getCalendarFormYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.YEAR, year);
		return cal;
	}

	// 20160907
	// O-514:随访一览画面的上月有效占比的值得分母是按照上个月的自然天数获取的，现在改成按照用机开始日期获取，以确保和患者基本信息页面的统计数据内的有效使用天数保持一致
	// start----------------------------------------------------
	private static int x; // 日期属性：年
	private static int y; // 日期属性：月
	private static Calendar localTime = Calendar.getInstance(); // 当前日期

	/**
	 * 功能：得到上个月份月初 格式为：xxxx-yy-zz (eg: 2007-12-01)<br>
	 *
	 * @return String
	 * @author pure
	 */
	public static String preMonth() {
		String strY = null;
		x = localTime.get(Calendar.YEAR);
		y = localTime.get(Calendar.MONTH);
		strY = y >= 10 ? String.valueOf(y) : ("0" + y);
		return x + "-" + strY + "-01";
	}

	/**
	 * 功能：得到上个月份月底 格式为：xxxx-yy-zz (eg: 2007-12-31)<br>
	 *
	 * @return String
	 * @author pure
	 */
	public static String preMonthEnd() {
		String strY = null;
		String strZ = null;
		boolean leap = false;
		x = Calendar.getInstance().get(Calendar.YEAR);
		y = localTime.get(Calendar.MONTH);
		if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
			strZ = "31";
		}
		if (y == 4 || y == 6 || y == 9 || y == 11) {
			strZ = "30";
		}
		if (y == 2) {
			leap = leapYear(x);
			if (leap) {
				strZ = "29";
			} else {
				strZ = "28";
			}
		}
		strY = y >= 10 ? String.valueOf(y) : ("0" + y);
		return x + "-" + strY + "-" + strZ;
	}

	/**
	 * 功能：判断输入年份是否为闰年<br>
	 *
	 * @param year
	 * @return 是：true 否：false
	 * @author pure
	 */
	public static boolean leapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;
		return leap;
	}
	// end----------------------------------------------------
}