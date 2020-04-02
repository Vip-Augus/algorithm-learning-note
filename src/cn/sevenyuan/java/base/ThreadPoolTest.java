package cn.sevenyuan.java.base;

import com.google.common.collect.Table;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池使用
 *
 * @author JingQ at 2020/3/28
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        float tmp = 1.5f;

//        newCachedThreadPoolTest();
    }

    private static void newFixedThreadPoolTest() {
        ExecutorService next = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Map<Integer, Integer> map = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        }
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
