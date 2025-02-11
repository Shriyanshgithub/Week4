package org.capgemini.List_Interface.Problem_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//declare the class to count the frequency of items
public class FrequencyOfElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Take the size of list
        System.out.println("Enter the total elements in the list");
        int size  = sc.nextInt();
        //create the list
        List<String> myList = new ArrayList<>();

        //add elements in the list
       for(int i =0; i<size ; i++){
           System.out.println("Enter the element : " + (i+1));
           String str = sc.next();
           myList.add(str);
       }

       findFrequency(myList);
    }
    //create the method to calculate the frequency of items
    public static void findFrequency(List<String> myList){
        //Hashmap
        HashMap<String,Integer> map = new HashMap<>();
        //For each loop to put the item in map
        for(String item : myList){
            map.put(item , map.getOrDefault(item , 0) +1);
        }

        //display the item and its frequency
        System.out.println(map);

    }
}
