package org.capgemini.Basic_Regex_Problems.ValidateUsername;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername {
    public static void main(String[] args) {
        //regex
        String regex = "^[a-zA-Z]+[0-9a-zA-Z_]{4,14}";
        String user = "user_123";

        //make the pattern of regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);

        System.out.println("user is valid " + matcher.matches());
    }
}
