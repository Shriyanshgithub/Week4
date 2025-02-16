package org.capgemini.AdvancedProblem.ExtractCurrency;

import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regex pattern to match currency values like "$45.99" or "10.50"
        String regex = "\\$?\\d+\\.\\d{2}";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Extract matches
        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        // Print results
        System.out.println(String.join(", ", currencyValues));
    }
}

