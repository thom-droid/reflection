package org.thom;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class AppTest {

    @Test
    public void annotationTest() {

        Class<Book> bookClass = Book.class;
        Annotation[] annotations = bookClass.getAnnotations();
        System.out.println("annotations = " + Arrays.toString(annotations));

    }

}
