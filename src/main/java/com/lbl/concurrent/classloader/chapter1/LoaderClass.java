package com.lbl.concurrent.classloader.chapter1;

public class LoaderClass {
    public static void main(String[] args) {
/*        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        MyObject myObject4 = new MyObject();


        System.out.println(myObject1.getClass() == myObject2.getClass());
        System.out.println(myObject1.getClass() == myObject3.getClass());
        System.out.println(myObject1.getClass() == myObject4.getClass());

        System.out.println(MyObject.x);*/

        System.out.println(Sub.x);
    }
}

class MyObject {

    public static int x = 10;

    static {
        System.out.println(x);
        x = 10 + 1;
//      静态语句块中只能访问到定义在静态语句块之前的静态变量，定义在他之后的变量只能赋值不能访问
//        y = 200;  //正确
//        System.out.println(y); //报错
    }

//    private static int y = 20;

}

class Parent {

    static {
        System.out.println("parent");
    }
}

class Sub extends Parent {

    public static int x = 100;

    static {
        System.out.println("child");
    }

}