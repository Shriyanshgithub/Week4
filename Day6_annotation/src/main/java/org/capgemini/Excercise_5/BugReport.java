package org.capgemini.Excercise_5;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//Use @Repeatable to allow multiple bug reports
@Repeatable(BugReports.class)
//Define an annotation @BugReport
public @interface BugReport{
    String description();
}

