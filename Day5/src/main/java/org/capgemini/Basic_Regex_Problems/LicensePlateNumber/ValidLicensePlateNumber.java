package org.capgemini.Basic_Regex_Problems.LicensePlateNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidLicensePlateNumber {
    public static void main(String[] args) {

        String regex = "^[A-Z]{2}\\d{4}$";
        String user = "UP9348";

        //make the pattern of regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);

        System.out.println("user is valid " + matcher.matches());
    }
}