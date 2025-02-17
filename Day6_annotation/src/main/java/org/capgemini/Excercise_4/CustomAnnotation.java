package org.capgemini.Excercise_4;


import java.lang.reflect.Method;

public class CustomAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
      Class<?> cl = Class.forName("org.capgemini.Excercise_4.TaskManager");

        Method[] methods = cl.getDeclaredMethods();

        for(Method method : methods){
            method.setAccessible(true);
            if(method.isAnnotationPresent(TaskInfo.class)){

                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.asignee());
                System.out.println("---------------------------");
            }
        }
    }

}

//Create a Custom Annotation and Use It
//✅ Problem Statement:
//Create a custom annotation @TaskInfo to mark tasks with priority and assigned person.
//        🔹 Steps to Follow:
//Define an annotation @TaskInfo with fields priority and assignedTo.
//Apply this annotation to a method in TaskManager class.
//Retrieve the annotation details using Reflection API.


