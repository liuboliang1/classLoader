package com.lbl.concurrent.classloader.chapter1;

/**
 * 加载：查找并且加载类的二进制数据
 * 链接：
 *      ——验证：确保被加载类的正确性
 *      ——准备：为类的静态变量分配内存，并将其初始化为默认值（int:0, double:0.0, long:0, 引用类型：null....）
 *      ——解析：把类的符号引用转换为类的直接引用
 * 初始化：为类的静态变量赋予正确的初始值
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    public static int x = 0;

    public static int y;

    /**
     *
     *  public static int x = 0;
     *  public static int y;
     *  private static Singleton instance = new Singleton();
     *
     *  System.out.println(singleton.x); // 1
     *  System.out.println(singleton.y); // 1
     *
     * 解析：
     *      int x = 0;
     *      int y = 0;
     *      instance = null;
     */

    /**
     * private static Singleton instance = new Singleton();
     * public static int x = 0;
     * public static int y;
     *
     * System.out.println(singleton.x);// 0
     * System.out.println(singleton.y);// 1
     *
     * 解析：
     *      1.instance = null;
     *      2.x = 0;
     *      3.y = 0;
     *      <p>
     *      <p>
     *      instance = new Singleton();
     *      x++=>x=1
     *      y++=>y=1
     *      <p>
     *      x = 0;
     *      y = 1;
     */

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
