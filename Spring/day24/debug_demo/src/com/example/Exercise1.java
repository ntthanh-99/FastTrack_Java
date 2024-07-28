package com.example;

public class Exercise1 {
    public static void main(final String... args) {
        final Object o = makeObject();

        printObject(o);
    }

    private static void printObject(final Object o) {
        System.out.println(o.toString());
    }

    private static Object makeObject() {
        final Object o = new Object();
        System.out.println(o);

        return null;
    }
}
