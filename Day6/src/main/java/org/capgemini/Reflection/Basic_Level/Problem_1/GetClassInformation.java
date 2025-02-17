package org.capgemini.Reflection.Basic_Level.Problem_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class GetClassInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the class name ");
        String className = sc.nextLine();
        sc.close();

        try{
            Class<?> tClass = Class.forName(className);
            System.out.println("Class : " + tClass.getName());

            //display constructors
            System.out.println("Constructor");
            Constructor<?>[] constructors = tClass.getDeclaredConstructors();
            for(Constructor<?> constructor : constructors){
                System.out.println(constructor);
            }

            //Display field
            System.out.println("Fields");
            Field[] fields = tClass.getDeclaredFields();
            for(Field field : fields){
                System.out.println(field);
            }

            //display methods
            System.out.println("Methods");
            Method[] methods = tClass.getDeclaredMethods();
            for(Method method : methods){
                System.out.println(method);
            }
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
