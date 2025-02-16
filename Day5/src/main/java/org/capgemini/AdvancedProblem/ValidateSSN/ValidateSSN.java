package org.capgemini.AdvancedProblem.ValidateSSN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String regex ="^([0-9]{3})-\\d{2}-\\d{4}$";
        String SSN = "123-44-6789";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(SSN);

        if(matcher.matches()){
            System.out.println("Matched : " + matcher.group());
        }
    }
}
