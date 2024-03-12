package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> innerMap = new LinkedHashMap<>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    };
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!innerMap.containsKey(key)) {
            return -1;
        }
        int value = innerMap.get(key);
        innerMap.remove(key);
        innerMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        innerMap.remove(key);
        innerMap.put(key, value);
    }
}
