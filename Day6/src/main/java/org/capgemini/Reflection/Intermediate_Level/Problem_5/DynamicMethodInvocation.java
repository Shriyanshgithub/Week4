package org.capgemini.Reflection.Intermediate_Level.Problem_5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            Class<?> cl = Class.forName("org.capgemini.Reflection.Intermediate_Level.Problem_5.MathOperations");
            Constructor<?> constructor = cl.getDeclaredConstructor();

            Object object = constructor.newInstance();
            System.out.println("Select the method(add, subtract, multiply)");
            String methodName = sc.nextLine();

            Method method = cl.getMethod(methodName , int.class,int.class);

            System.out.println("Enter the value 1");
            int value1 = sc.nextInt();

            System.out.println("Enter the value 2");
            int value2 = sc.nextInt();

            Object result = method.invoke(object,value1 , value2);

            System.out.println("The result is : " + result);

        }
        catch(Exception e){
            System.out.println("class not found : " + e.getMessage());
        }
    }
}
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
