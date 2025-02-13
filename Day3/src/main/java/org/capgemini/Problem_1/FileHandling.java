package org.capgemini.Problem_1;

/*File Handling - Read and Write a Text File
📌 Problem Statement:
Write a Java program that reads the contents of a text file and writes it into a new file. If the source file does not exist, display an appropriate message.
Requirements:
Use FileInputStream and FileOutputStream.
Handle IOException properly.
Ensure that the destination file is created if it does not exist.*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        //Store absolute file path
        String FilePath = "C:/Users/HP/Desktop/Week4/Day3/src/main/resources/file.txt";

        // try block to read the data from one file and copy to new file
       try(FileInputStream fs = new FileInputStream(FilePath); FileOutputStream os = new FileOutputStream("C:/Users/HP/Desktop/Week4/Day3/src/main/resources/file2.txt")){
           int byteData ;

           //copy the to the new file File2.txt
           while((byteData = fs.read()) != -1){
            os.write(byteData);
        }

        System.out.println("File copy successfully");
    }
       //catch block to handle exception
       catch (IOException e) {
        e.printStackTrace();
    }

    }
}
