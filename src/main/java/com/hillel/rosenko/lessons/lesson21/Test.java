package com.hillel.rosenko.lessons.lesson21;

import java.lang.annotation.*;
import java.util.logging.Level;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    int priority() default 1;
}
