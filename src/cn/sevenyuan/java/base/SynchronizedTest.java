package cn.sevenyuan.java.base;

/**
 * @author JingQ at 2020/3/28
 */
public class SynchronizedTest {

    private static SynchronizedTest instance;

    public static SynchronizedTest getInstance() {
        if (instance == null) {
            synchronized (SynchronizedTest.class) {
                if (instance == null) {
                    instance = new SynchronizedTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        synchronized (SynchronizedTest.class) {
            System.out.println("Hello World");
        }
    }
}
