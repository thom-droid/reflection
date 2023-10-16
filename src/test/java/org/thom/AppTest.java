package org.thom;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AppTest {

    @Test
    public void mybookAnnotations() {

        // check if annotation is inherited

        // annotation scoped to MyBook
        Annotation[] annotations = MyBook.class.getAnnotations();

        Arrays.stream(annotations).forEach(a -> Assert.assertTrue(a.annotationType().isAssignableFrom(BookAnnotation.class)));

        String value = "une belle ami";
        int num = 2;

        BookAnnotation bookAnnotation = MyBook.class.getAnnotation(BookAnnotation.class);

        Assert.assertEquals(value, bookAnnotation.value());
        Assert.assertEquals(num, bookAnnotation.number());

    }

}
