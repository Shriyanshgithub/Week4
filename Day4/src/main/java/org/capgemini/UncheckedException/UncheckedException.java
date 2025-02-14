package org.capgemini.UncheckedException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UncheckedException {

        public static void main(String[] args) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                try{
                    //takes two inputs and reads them
                    System.out.print("Give input1: ");
                    int a = Integer.parseInt(reader.readLine());
                    System.out.print("Give input2: ");
                    int b = Integer.parseInt(reader.readLine());
                    //throws inner exception
                    System.out.println(a/b);
                }catch (ArithmeticException | NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }


