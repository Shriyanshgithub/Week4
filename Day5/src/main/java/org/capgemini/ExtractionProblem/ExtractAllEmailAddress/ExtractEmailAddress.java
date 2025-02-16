package org.capgemini.ExtractionProblem.ExtractAllEmailAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmailAddress {
    public static void main(String[] args) {
        //regex to extract the pattern of date
        String regex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\b";
        //Scanner class take user from input
        Scanner sc = new Scanner(System.in);
        //take user from input
        String str = sc.nextLine();

        //method call
        findPattern(str,regex);
    }
    public static void findPattern(String str , String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> list = new ArrayList<>();
        while(matcher.find()){
            list.add(matcher.group());
        }
        System.out.println(String.join(", ", list));
    }
}

