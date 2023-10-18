package org.thom;

import org.junit.jupiter.api.Test;
import org.thom.movie.Movie;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

public class MovieAppTest {

    @Test
    public void reflectionTest() throws Exception {

        Class<?> bookClass = Class.forName("org.thom.Book");
        Constructor<?> bookClassConstructor = bookClass.getConstructor(String.class, String.class, String.class);
        Book book = (Book) bookClassConstructor.newInstance("name1", "name2", "name3");

        Field name = book.getClass().getDeclaredField("name");
        checkModifier(name);

        Book book1 = new Book("name2", "name2", "name2");

        String o1 = (String) name.get(book);
        String o2 = (String) name.get(book1);

        assertNotEquals(o1, o2);

        // set new value to a `book` instance
        name.set(book, o2);

        o1 = (String) name.get(book);

        assertEquals(o1, o2);


        Field number = Book.class.getDeclaredField("number");

        checkModifier(number);

        Integer o3 = (Integer) number.get(book);
        Integer o4 = (Integer) number.get(book1);

        assertEquals(o3, o4);

        number.set(book, 150);

        o3 = (Integer) number.get(book);

        assertNotEquals(o3, o4);

    }

    @Test
    public void methodInvocation() throws Exception {
        Movie movie = new Movie();
        Method printMovieName = Movie.class.getDeclaredMethod("sum", int.class, int.class);
        printMovieName.setAccessible(true);

        int resultBeforeReflection = movie.sum(15, 10);

        assertEquals(resultBeforeReflection, 25);

        Integer resultAfter = (Integer) printMovieName.invoke(movie, 25, 10);

        assertEquals(resultAfter, 35);

    }

    public static void checkModifier(Field field) {
        if (field.getModifiers() != Modifier.PUBLIC) field.setAccessible(true);
    }

}
