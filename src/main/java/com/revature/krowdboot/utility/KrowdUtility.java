package com.revature.krowdboot.utility;

/**
 * 
 * The general utility class for the Krowd v2 application.
 * 
 * @author Eddy Soma
 *
 */
public class KrowdUtility {

	/**
	 * 
	 * This methods will return a long formatted string from the full stack trace of
	 * a throwable.
	 * 
	 * @param throwObj
	 * @return the formatted string
	 */
	public static String formatStackTrace(Throwable throwObj) {

		if (throwObj == null) {
			return null;
		}

		StringBuilder stackTraceBuilder = new StringBuilder();
		for (StackTraceElement ste : throwObj.getStackTrace()) {
			stackTraceBuilder.append("\n\t" + ste.toString());
		}

		return new String(stackTraceBuilder);

	}

}
