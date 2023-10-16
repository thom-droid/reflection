package org.thom;

@BookAnnotation(value = "cure", isSuper = true, number = 1)
public class Book {

    private String name = "a";

    private static String B = "B";

    private static final String C = "book";

    public String d = "d";

    protected String e = "e";

    public Book(String name, String d, String e) {
        this.name = name;
        this.d = d;
        this.e = e;
    }

    public Book() {
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("Book.g");
    }

    public int h() {
        return 100;
    }


}
