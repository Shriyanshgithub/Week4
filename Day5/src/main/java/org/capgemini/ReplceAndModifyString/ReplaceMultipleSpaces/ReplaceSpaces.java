package org.capgemini.ReplceAndModifyString.ReplaceMultipleSpaces;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String str = "This  is   an  example  with  multiple  space";

        String replaceText = str.replaceAll("\\s+", " ");

        System.out.println("Repalced text is : " + replaceText);
    }
}
