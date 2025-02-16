package org.capgemini.ReplceAndModifyString;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculate calculate = new Calculate();
        Class<?> cl = calculate.getClass();

        Method method = cl.getDeclaredMethod("add",int.class,int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(calculate ,5,10);
        System.out.println(result);


    }

}
class Calculate{
    public int add(int a , int b){
        return a+b;
    }
}