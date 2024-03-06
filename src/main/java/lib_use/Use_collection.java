package lib_use;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Use_collection {
    // 允许重复， Set 不允许重复

    public Use_collection() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(2);
        for (int i = 0; i < 10; i++) {
            collection.add((int) (Math.random() * 10));
        }
        Use_collections(); // 使用静态工具集
    }

    public void Use_collections() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((int) (Math.random() * 10));
        }
        walk(arrayList);
        Collections.shuffle(arrayList);
        walk(arrayList);
        Collections.sort(arrayList);
        walk(arrayList);
    }
    protected void walk(ArrayList arrayList) {
        System.out.println();
        for (Object obj : arrayList) {
            System.out.printf("%d ", obj);
        }
    }
}
