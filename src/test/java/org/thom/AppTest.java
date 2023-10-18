package org.thom;


import org.junit.jupiter.api.Test;
import org.thom.movie.BookAnnotation;
import org.thom.movie.MyBook;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void mybookAnnotations() {

        // check if annotation is inherited

        // annotation scoped to MyBook
        Annotation[] annotations = MyBook.class.getAnnotations();

        Arrays.stream(annotations).forEach(a -> assertTrue(a.annotationType().isAssignableFrom(BookAnnotation.class)));

        String value = "une belle ami";
        int num = 2;

        BookAnnotation bookAnnotation = MyBook.class.getAnnotation(BookAnnotation.class);

        assertEquals(value, bookAnnotation.value());
        assertEquals(num, bookAnnotation.number());

    }

}
