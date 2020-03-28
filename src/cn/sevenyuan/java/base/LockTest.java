package cn.sevenyuan.java.base;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JingQ at 2020/3/27
 */
public class LockTest {


    private static ReentrantLock lock = new ReentrantLock();

    private static volatile  int i = 0;


    public static void main(String[] args) throws Exception {
        Thread thread1 = nonFairLockThread("1");
        Thread thread2 = nonFairLockThread("2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("the last number is : " + i);
    }

    private static Thread nonFairLockThread(String threadName) {
        return new Thread(() -> {
            lock.lock();
            try {
                for (int index = 0; index < 100000; index++) {
                    System.out.println("current thread name: " + threadName + " and number is :" + i);
                    i++;
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        });
    }
}
