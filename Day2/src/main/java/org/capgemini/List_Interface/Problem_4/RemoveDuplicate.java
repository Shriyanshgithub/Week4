package org.capgemini.List_Interface.Problem_4;

import java.util.*;

//declare the class Remove Duplicate
public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Take the size of list
        System.out.println("Enter the total number in the list");
        int size  = sc.nextInt();
        //create the list
        List<Integer> myList = new ArrayList<>();

        //add elements in the list
        for(int i =0; i<size ; i++){
            System.out.println("Enter the number : " + (i+1));
            int number = sc.nextInt();
            myList.add(number);
        }
        //store the list in the set after removing the duplicate element
        List<Integer> list = removeDuplicateElement(myList);
        //display the list without changing th order
        System.out.println(list);
    }

    //create the method to remove the duplicate element
    public static List<Integer> removeDuplicateElement(List<Integer> mylist){
        //create the set to check duplicate element
        Set<Integer> myset = new HashSet<>();
        //create the new list to add number without duplicate
        List<Integer> resultList = new ArrayList<>();
        for(int number : mylist){

            if(!myset.contains(number)){
                resultList.add(number);
            }
            myset.add(number);
        }
        return resultList;
    }
}
