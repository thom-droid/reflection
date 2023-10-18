package org.thom.movie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface BookAnnotation {

    String value() default "thom";

    int number() default 0;

    boolean isSuper() default false;

}
