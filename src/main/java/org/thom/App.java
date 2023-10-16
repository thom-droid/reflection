package org.thom;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<Book> bookClass = Book.class;

        Field[] fields = bookClass.getFields();

        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println("modifiers = " + modifiers);
            System.out.println(Modifier.isAbstract(modifiers));
        });

        Arrays.stream(bookClass.getInterfaces()).forEach(System.out::println);


//        Book book = new Book();
//
//        Class<? extends Book> aClass = book.getClass();
//        Class<?> aClass1 = Class.
//                forName("org.thom.Book");
    }
}
