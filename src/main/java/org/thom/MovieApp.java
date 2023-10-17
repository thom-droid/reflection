package org.thom;

import org.thom.movie.Movie;

import java.lang.reflect.*;
import java.util.Arrays;

public class MovieApp {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> movieClass = Class.forName("org.thom.movie.Movie");
        Constructor<?> movieConstructor = movieClass.getConstructor();
        Movie movie = (Movie) movieConstructor.newInstance();

        Constructor<?> movieConstructor2 = movieClass.getConstructor(String.class);
        Movie something = (Movie) movieConstructor2.newInstance("something");

        Class<?> bookClass = Class.forName("org.thom.Book");
        Constructor<?> bookClassConstructor = bookClass.getConstructor();
        Book book = (Book) bookClassConstructor.newInstance();

        System.out.println("movie = " + movie);
        System.out.println("movie2 = " + something);
        System.out.println("something = " + something.B);

        Field b = Book.class.getDeclaredField("B"); // private static
        int modifiers = b.getModifiers();
        System.out.println("modifiers = " + modifiers);
        b.setAccessible(true);
        Object o = b.get(null); // static, null
        System.out.println("o = " + o);
        b.set(null, "Changed!!");
        System.out.println("b.get(null) = " + b.get(null));





    }


}
