package org.capgemini.ExtractionProblem.ExtractDates;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDateFromString {
    public static void main(String[] args) {
        //regex to extract the pattern of date
      String regex = "\\d{2}/\\d{2}/\\d{4}";
      //Scanner class take user from input
      Scanner sc = new Scanner(System.in);
      //take user from input
      String str = sc.nextLine();

      //method call
      findPattern(str,regex);
    }
    //method to find the pattern
    public static void findPattern(String str , String regex){
        //Pattern class that compile regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        //matches the date pattern in the string
        while(matcher.find()){
            System.out.println("Matched " + matcher.group());
        }
    }
}

