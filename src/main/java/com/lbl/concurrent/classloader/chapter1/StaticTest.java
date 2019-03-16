package com.lbl.concurrent.classloader.chapter1;

public class StaticTest {

    public static void main(String[] args) {
        System.out.println(B.B); // 1
    }

}
class A {
    static {
        A = 2;
    }
    public static int A = 1;
}
class B extends A {
    public static int B = A;
}