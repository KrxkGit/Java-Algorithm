package lib_use;

import java.util.PriorityQueue;

public class Heap {
    public Heap() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 小顶堆
        priorityQueue.offer(11);
        priorityQueue.offer(1);
        System.out.println(priorityQueue.peek());
    }
}
