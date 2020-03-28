package cn.sevenyuan.java.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池使用
 *
 * @author JingQ at 2020/3/28
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        newCachedThreadPoolTest();
    }

    private static void newFixedThreadPoolTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("current thread is: " + Thread.currentThread().getName() + " timestamp: " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // noop
                }
            });
        }
    }

    private static void newCachedThreadPoolTest() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"正在执行 " + index);
            });
        }
        for (int i = 0; i < 5; i++) {
            final int index = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"正在执行 " + index);
            });
        }
    }
}
