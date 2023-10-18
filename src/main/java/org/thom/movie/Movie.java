package org.thom.movie;

public class Movie {

    public static String A = "A";

    public String B = "B";

    public void c() {
        System.out.println("c");
    }

    private void printMovieName () {
        System.out.println("no movie name");
    }

    public void printParameter(String a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public int sum(int left, int right) {
        return left + right;
    }


    public Movie() {
    }

    public Movie(String b) {
        B = b;
    }
}
