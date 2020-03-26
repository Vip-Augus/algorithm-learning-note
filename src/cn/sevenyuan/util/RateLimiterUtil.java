package cn.sevenyuan.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JingQ at 2020/3/26
 */
public class RateLimiterUtil {

    public static void main(String[] args) throws InterruptedException {

        final RateLimiter rateLimiter = RateLimiter.create(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int numberOfTask = 10;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfTask);
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTask; i++) {
            final int j = 1;
            executorService.submit(() -> {
                rateLimiter.acquire(1);
                try {
                    // do something
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // log what happended
                }
                System.out.println(Thread.currentThread().getName() + "do something, task mark: " + j + " current time is :" + System.currentTimeMillis());
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("total time consumering : " + (end - start));
    }
}
