package org.capgemini.AdvancedProblem.Validate_Credit_Card;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCardNumber{
    public static void main(String[] args) {
        String regex = "^4\\d{15}$";
        String number = "4234485438438347";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        if (matcher.matches()) { // Ensure a match is found
            System.out.println("Matched: " + matcher.group());
        } else {
            System.out.println("No match found.");
        }
    }
}
