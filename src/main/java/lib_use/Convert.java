package lib_use;

import java.util.ArrayList;

public class Convert {
    public Convert() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(6);
        Integer[] arr = arrayList.toArray(new Integer[0]);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.ceil((Math.random() * 10));
        }
        System.out.println();
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
