package org.capgemini.TODO_Task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Annotation to mark pending tasks (features)
// Retained at runtime and applicable to methods
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
    String task();         // Description of the task
    String assignedTo();   // Developer responsible
    String priority() default "MEDIUM";  // Optional priority (default: "MEDIUM")
}

