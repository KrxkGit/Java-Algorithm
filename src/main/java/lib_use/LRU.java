package lib_use;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    // 通过 库实现
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // 改写此函数即可实现
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
