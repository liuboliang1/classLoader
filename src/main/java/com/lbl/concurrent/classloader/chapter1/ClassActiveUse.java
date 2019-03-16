package com.lbl.concurrent.classloader.chapter1;

import java.util.Random;

/**
 * 一、主动使用的分类
 *     1. new 直接使用
 *     2. 访问某个类或者接口的静态变量，或者对静态变量进行复制操作
 *          2.1.对某个类的静态变来那个进行读写 ->class
 *          2.2.对接口中静态变量进行读取      ->interface
 *     3. 调用静态方法
 *     4. 反射某个类
 *     5. 初始化一个子类
 *     6. 启动类 比如： java HelloWorld
 * 除了上述6中方式外，其余的都是被动使用，不会导致类的初始化
 *
 * 二、类的被动使用
 *    1. 通过子类访问父类的static变量，不会导致子类的初始化.
 *    2. 定义引用数组，不会初始化类
 *    3. final修饰的常量会在编译期间放到常量池中，不会初始化类
 *    4. final修饰的复杂类型，在编译期间无法计算得出，会初始化类（调用static代码块）
 *
 */
public class ClassActiveUse {

    static {
        System.out.println("ClassActiveUse");
    }

    public static void main(String[] args) throws ClassNotFoundException {
/*        new Obj();
        System.out.println(I.a);*/

//        System.out.println(Obj.salary);
//        Obj.printSalary();

//        Class.forName("Obj");


//        System.out.println(Child.age);

//        (1)通过子类访问父类的static变量，不会导致子类的初始化.
//        System.out.println(Child.salary);

        //(2）定义引用数组，不会初始化类
//        Obj[] arrays = new Obj[10];


        //(3)final修饰的常量会在编译期间放到常量池中，不会初始化类
//        System.out.println(Obj.salary);
        //(4)final修饰的复杂类型，在编译期间无法计算得出，会初始化类
        System.out.println(Obj.x);
    }


}

class Obj {

    public static final long salary = 100000L;

    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("Obj 被初始化.");
    }

    public Obj() {
        System.out.println("Obj 被初始化 construction.");
    }

    public static void printSalary() {
        System.out.println("========Obj=printSalary");
    }
}


class Child extends Obj {

    public static int age = 32;

    static {
        System.out.println("Child 被初始化.");
    }
}

interface I {

    int a = 10;
}

//访问某个类或者接口的静态变量，或者对该静态变量进行赋值操作
//1.对某个类的静态变来那个进行读写 ->class
//2.对接口中静态变量进行读取      ->interface
