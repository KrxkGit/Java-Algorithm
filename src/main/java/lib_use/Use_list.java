package lib_use;

import java.util.LinkedList;

public class Use_list {
    public Use_list() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(8);
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(7);

        show(linkedList);
        linkedList.remove(0);
        show(linkedList);

        linkedList.sort((a, b) -> {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }else  {
                return 0;
            }
        });
        show(linkedList);

    }
    void show(LinkedList<Integer> linkedList) {
        System.out.println("result");
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }
}
