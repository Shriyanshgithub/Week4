package org.capgemini.AdvancedProblem.ExtractingProgrammingLanguage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingProgrammingLanguage {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript , but I haven't tried Go yet.";
        String[] str = {"Java" , "Python", "Go" , "JavaScript"};

        for(String word : str){
            String regex = "\\b(" + word + ")\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while(matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
