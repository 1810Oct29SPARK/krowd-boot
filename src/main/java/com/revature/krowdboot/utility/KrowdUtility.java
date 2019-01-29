package com.revature.krowdboot.utility;

public class KrowdUtility {

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
