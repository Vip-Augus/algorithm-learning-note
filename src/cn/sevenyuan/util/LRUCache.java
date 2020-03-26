package cn.sevenyuan.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现 LRU 算法
 * @author JingQ at 2020/3/24
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");

        System.out.println(lruCache);
        lruCache.get(2);
        System.out.println(lruCache);

        lruCache.put(4, "d");
        System.out.println(lruCache);
    }

    private int cacheSize;

    public LRUCache(int cacheSize) {
        // true 表示访问顺序，false 表示插入顺序
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
