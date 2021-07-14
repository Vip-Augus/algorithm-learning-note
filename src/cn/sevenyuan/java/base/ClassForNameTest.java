package cn.sevenyuan.java.base;

import com.sun.tools.javac.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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



    public static void rotate1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n)
            return;
        int temp;
        // 先按照 1 6 11 16 对角线，反斜线进行翻转
        for (int i = 0; i < m - 1; i++) {
            for (int j = n - 1; j > 0; j--) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 水平中线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2 ; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = temp;
            }
        }
        System.out.println("垂直中线反转，交换两边：");

    }
}
