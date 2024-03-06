package lib_use;

import java.util.LinkedList;
import java.util.Queue;

public class Use_queue {
    public Use_queue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        queue.offer(3);
        print(queue);

        queue.poll();
        print(queue);

    }
    private <T> void print(Queue<T> queue) {
        System.out.println();
        for (T t : queue) {
            System.out.printf("%d ", t);;
        }
    }
}
