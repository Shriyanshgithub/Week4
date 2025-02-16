package org.capgemini.Basic_Regex_Problems.ValidateHexColorCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTheHexColor {
    public static void main(String[] args) {
        String regex = "^#[A-Za-z]{2,3}+\\d{3,4}$";
        String user = "#ff4800";

        //make the pattern of regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);

        System.out.println("user is valid " + matcher.matches());
    }
}
