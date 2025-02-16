package org.capgemini.ExtractionProblem.ExtractLinkFromWebPage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLink {

        public static void main(String[] args) {
            //regex to extract the pattern of date
            String regex = "https?:\\/\\/www?\\.[a-zA-Z]+\\.[a-z]{2,6}";
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

            while(matcher.find()){

             System.out.println("Matched : " + matcher.group());
            }

        }
    }

