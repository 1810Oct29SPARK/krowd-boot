package com.revature.krowdboot.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * The utility class that handles email validation.
 * 
 * @author Danny Trevino
 *
 */
public class EmailValidator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	/**
	 * 
	 * This methods returns true if the input string is a valid email address.
	 * 
	 * @param email
	 * @return the boolean value
	 */
	public static boolean isValid(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
