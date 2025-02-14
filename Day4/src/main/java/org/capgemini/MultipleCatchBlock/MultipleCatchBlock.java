package org.capgemini.MultipleCatchBlock;
import java.util.Scanner;

public class MultipleCatchBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example array (can be replaced with user input)
        Integer[] array = {10, 20, 30, 40, 50};

        System.out.print("Enter the index to retrieve value: ");
        int index = scanner.nextInt();

        try {
            // Attempt to access the specified index
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            // Close the scanner to prevent resource leak
            scanner.close();
        }
    }
}
