package lib_use;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Use_map {
    public Use_map() {
        Map<String, Integer> map = new HashMap<>(); // 哈希表
        Map<String, Integer> map1 = new ConcurrentHashMap<>(); // 线程安全哈希表
        map.put("krxk", 2);
        map1.put("krxk", 1);
        map1.put("kkk", 4);
        map1.put("kk", 3);
        System.out.println(map.get("krxk"));;
        System.out.println(map1.isEmpty());
        System.out.println(map1.size());
        System.out.println(map1.containsKey("k"));
        System.out.println(map1.containsKey("krxk"));
        System.out.println(map1.entrySet());
        System.out.println(map1.keySet());
        System.out.println(map1.values());
        System.out.println(map1.hashCode());

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
