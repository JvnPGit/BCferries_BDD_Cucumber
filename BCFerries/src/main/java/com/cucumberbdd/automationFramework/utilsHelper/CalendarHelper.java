package com.cucumberbdd.automationFramework.utilsHelper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.cucumberbdd.automationFramework.base.Base;

public class CalendarHelper extends Base {
	private static Logger Log4j = Logger.getLogger(CalendarHelper.class.getName());

	/**
	 * This method returns the date format in mm/dd/yyyy hh:mm:ss
	 * @return
	 */
	public static String getDateFormat() {
		String currentDate = null;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			
			currentDate = dateFormat.format(date);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}

		return currentDate;
	}
	
	/**
	 * This method returns the date format in mm/dd/yyyy hh:mm:ss
	 * @return
	 */
	public static String getSimpleDateFormat() {
		String currentDate = null;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
			Date date = new Date();
			
			currentDate = dateFormat.format(date);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println(e.getMessage());
		}

		return currentDate;
	}

	/**
	 * This method returns the Calendar date in mm/dd/yyyy hh:mm:ss
	 * @return
	 */
	public static String getCalendarDate() {
		String currentDate = null;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Calendar cal = Calendar.getInstance();

			currentDate = dateFormat.format(cal);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}

		return currentDate;
	}

	/**
	 * This method is used to get the Local Date Time in MM/dd/yyyy HH:mm:ss
	 * @return
	 */
	public static String getLocalDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	/**
	 * This method returns the current time in hh:mm:ss:nnnnnnnnn
	 * @return
	 */
	public static String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		return now.format(DateTimeFormatter.ofPattern("hh:mm:ss.nnnnnnnnn"));
	}

	/**
	 * This method returns the time taken to load a web page
	 * @param beforeTime
	 * @param afterTime
	 * @return
	 */
	public static double getPageLoadTime(String beforeTime, String afterTime) {
		try {
			String[] beforeTimeData = beforeTime.split(":");
			String[] afterMinuteData = afterTime.split(":");
			if (Integer.parseInt(afterMinuteData[0]) == Integer.parseInt(beforeTimeData[0])) {
				return (Double.parseDouble(afterMinuteData[1]) - Double.parseDouble(beforeTimeData[1]));
			} else {
				return 0;
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return 0; 
	}

	/**
	 * This method returns the local date
	 * @return
	 * @throws ParseException
	 */
	public static String getLocalDate() throws ParseException {
		String currentDate = null;
		Date date = null;
		try {
			SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.US);
			date = dtf.parse(currentDate);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return date.toString();
	}

	/**
	 * This method returns the difference between two times
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long getDifferenceBetweenTimes(String time1, String time2) {
		long result = 0;
		SimpleDateFormat dtf = new SimpleDateFormat("hh:mm:ss");

		try {
			Date firstDate = dtf.parse(time1);
			Date secondDate = dtf.parse(time2);

			result = secondDate.getTime() - firstDate.getTime();
			result = result / 1000;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return result;
	}

	/**
	 * This method returns the minutes from the current time
	 * @return
	 */
	public static String getMinuteFromCurrentTime() {
		String minutes = null;

		try {
			LocalDateTime now = LocalDateTime.now();
			minutes = now.format(DateTimeFormatter.ofPattern("mm"));
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return minutes;
	}
	
	/**
	 * This method is used to format the date in MM/dd/yyyy HH:mm:ss
	 * @param userDate
	 * @return
	 */
	public static String formatDate(String userDate) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
			LocalDate localDate = LocalDate.now();

			userDate = dtf.format(localDate);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		} 
		
		return userDate;
	}
	
	/**
	 * This method returns the timestamp in the format MM.dd.yyyy HH.mm.ss
	 * @return
	 */
	public static String getTimeStamp() {
		String formatStr = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			formatStr = sdf.format(timestamp);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}  
		
		return formatStr;
	}
	
	/**
	 * This method returns the timestamp in the format MM-dd-yyyy HH:mm:ss
	 * @return
	 */
	public static String formatTimeStamp() {
		String formatStr = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			formatStr = sdf.format(timestamp);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}  
		
		return formatStr;
	}
	
	/**
	 * This method is used to get the current timestamp in the format _dd_MMM_yyyy_HH_mm_ss
	 * @return
	 */
	public static String getCurrentTimeStampWithMonth() {
		String timeStamp = null;
		
		try {
			LocalDateTime now = LocalDateTime.now();
			timeStamp = now.format(DateTimeFormatter.ofPattern("MM:dd:yyyy:hh:mm:ss.nnnnnnnnn"));
				
			return timeStamp;
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the timestamp");
			return timeStamp;
		}
	}
	
	/**
	 * This method is used to get the current timestamp in the format MM:dd:yyyy:hh:ss:nnnnnnnn
	 * @return
	 */
	public static String getTimestampWithMonth() {
		String timestamp = null;
		
		try {
			Date date = new Date();
	        SimpleDateFormat format = new SimpleDateFormat("_dd_MMM_yyyy_HH_mm_ss");
	        timestamp = format.format(date);
			
			return timestamp;
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the timestamp");
			return timestamp;
		}
	}
	
	/**
	 * This method is used to get the current timestamp with AM/PM in the format MM-dd-yyyy HH:mm:ss AM/PM
	 * @return
	 */
	public static String getCurrentTimestampWithAMPM() {
		String timestamp = "";
		
		try  {
			LocalDateTime now = LocalDateTime.now();
			timestamp = now.format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh.mm.ss_a"));
			return timestamp;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the current timestamp with AM/PM - " + e.getMessage());
			return timestamp;
		}
	}
	
	/**
	 * This method returns the timestamp in the format MM.dd.yyyy
	 * @return
	 */
	public static String getTimeStampWithOnlyDate() {
		String formatStr = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			formatStr = sdf.format(timestamp);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}  
		
		return formatStr;
	}
}
