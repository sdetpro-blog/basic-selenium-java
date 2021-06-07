package com.sdetpro.test;

@FunctionalInterface
interface Calculate {
    int sum(int x, int y);
}

public class TestFuntionalInterface {
    private static void engine(Calculate cal) {
        int x = 2, y = 4;
        System.out.println(cal.sum(x, y));
    }

    public static void main(String[] argv) {
        TestFuntionalInterface.engine((x, y) -> x + y);
    }
}
