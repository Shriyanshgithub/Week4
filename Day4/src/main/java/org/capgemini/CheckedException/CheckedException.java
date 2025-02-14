package org.capgemini.CheckedException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//declare class CheckedException
public class CheckedException {
    public static void main(String[] args) {

        //store absolute file path
        String Filepath = "C:/Users/HP/Desktop/Week4/Day4/src/main/resources/data.txt";

        //try block that may thorw exception
        try(FileReader fs = new FileReader(Filepath)){

            while(fs.ready()){
                System.out.print((char)fs.read());
            }
        }
        //catch block to handle exception
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
