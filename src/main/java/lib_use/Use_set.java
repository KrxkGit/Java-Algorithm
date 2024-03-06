package lib_use;

import java.util.HashSet;
import java.util.Set;

public class Use_set {
    public Use_set() {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.remove(2);
        set.add(7);
        set.add(9);

        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
