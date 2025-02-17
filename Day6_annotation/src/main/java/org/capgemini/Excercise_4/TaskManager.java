package org.capgemini.Excercise_4;

public class TaskManager {
    @TaskInfo(priority = Priority.MEDIUM, asignee = "Shriyansh")
    public static void Deploy(){
        System.out.println("The project is deploy");
    }

    @TaskInfo(priority = Priority.HIGH , asignee = "Himanshu")
    public static void reviewTask() {
        System.out.println("Task is being reviewed...");
    }
}
