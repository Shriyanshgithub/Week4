package org.capgemini.ReplceAndModifyString.CensorBadWords.CensorBadWords;

import java.util.Arrays;
import java.util.*;
public class CensorBadWord {
    public static void main(String[] args) {
        String sentence = "This is an damn bad example with some stupid words";
        List<String> words = Arrays.asList("damn" , "stupid");

        String censorSentence = censoredBadWord(sentence,words);
        System.out.println("new sentence is : " + censorSentence);
    }
    public static String censoredBadWord(String sentence , List<String> word){
        for(String badWord : word){
            String replacement = "*".repeat(badWord.length());
            sentence = sentence.replaceAll(badWord , replacement);
        }
        return sentence;
    }
}

