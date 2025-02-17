package org.capgemini.Reflection.Basic_Level.Problem_3;
import  java.lang.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokePrivateMethod {
    public static void main(String[] args) {
       try{
           Calculator calculator = new Calculator();
           //create class object dynamically
           Class<?> cl = calculator.getClass();

           Method method = cl.getDeclaredMethod("multiply", int.class, int.class);
           // Allow access to private method
           method.setAccessible(true);

           // Invoke method dynamically
           double result = (double)method.invoke(calculator , 5,5);
           System.out.println("The result of method is : " + result);
       }
       //catch block to handle exception
        catch (NoSuchMethodException |InvocationTargetException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }
}
//declare calculator class
class Calculator{
    private double multiply(int a , int b){
        return a*b;
    }
}
