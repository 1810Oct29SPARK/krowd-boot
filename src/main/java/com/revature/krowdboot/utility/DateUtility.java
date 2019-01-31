package com.revature.krowdboot.utility;

import java.time.LocalDateTime;

/**
 * 
 * The DateUtility class contains static utility methods such as comparing
 * formatted date strings
 * 
 * @author Eddy Soma
 *
 */
public class DateUtility {

	/**
	 * 
	 * The method compares two formatted date strings and will return true if the
	 * first date is chronologically earlier than the second date, or false
	 * otherwise.
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return the comparison boolean value
	 */
	public static boolean firstIsEarlier(String firstDate, String secondDate) {

		LocalDateTime fdt = LocalDateTime.parse(firstDate);
		LocalDateTime sdt = LocalDateTime.parse(secondDate);

		return fdt.compareTo(sdt) < 0;

	}

	/**
	 * 
	 * The method compares two formatted date strings and will return true if the
	 * first date is chronologically later than the second date, or false otherwise.
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return the comparison boolean value
	 */
	public static boolean firstIsLater(String firstDate, String secondDate) {

		LocalDateTime fdt = LocalDateTime.parse(firstDate);
		LocalDateTime sdt = LocalDateTime.parse(secondDate);

		return fdt.compareTo(sdt) > 0;
	}

	/**
	 * 
	 * The method compares a formatted date string against the current time will
	 * return true if the date is chronologically later than the current date, or
	 * false otherwise.
	 * 
	 * @param firstDate
	 * @return the comparison boolean value
	 */
	public static boolean isNotPastDate(String date) {

		LocalDateTime dt = LocalDateTime.parse(date);
		LocalDateTime current = LocalDateTime.now();

		return dt.compareTo(current) < 0;

	}

}
