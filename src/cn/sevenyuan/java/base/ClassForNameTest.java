package cn.sevenyuan.java.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试类的加载方法
 *
 * @author JingQ at 2020/3/27
 */
public class ClassForNameTest {

    public static void main(String[] args) throws Exception {
        // class.forName 会执行 static 静态方法块
        // 而底层使用的 classLoader 的功能：将 .class 文件加载到 jvm 虚拟机
        Class cls = Class.forName("cn.sevenyuan.java.base.Book");
        // newInstance 会调用对象的无参构造函数
        Book book = (Book) cls.newInstance();
        System.out.println(book);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
    }

}
