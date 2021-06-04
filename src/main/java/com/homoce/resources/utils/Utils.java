package com.homoce.resources.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {
	
	public static int calculaIdade(String dataNasc, String pattern) {

		DateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;

		try {

			dataNascInput = sdf.parse(dataNasc);

		} catch (Exception e) {}

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNascInput);

		Calendar today = Calendar.getInstance();

		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {
			age--;
		}

		return age;
	}
}
