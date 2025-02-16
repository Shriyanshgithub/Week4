package org.capgemini.Advance_Problem.Problem_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatter {

    private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})$");

    public static String formatDate(String inputDate) {
        if (inputDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        Matcher matcher = DATE_PATTERN.matcher(inputDate);
        if (matcher.matches()) {
            String year = matcher.group(1);
            String month = matcher.group(2);
            String day = matcher.group(3);
            return day + "-" + month + "-" + year; // Convert to dd-MM-yyyy
        } else {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd.");
        }
    }
}

