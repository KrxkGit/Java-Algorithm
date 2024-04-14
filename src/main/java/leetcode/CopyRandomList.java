package leetcode;

import java.util.HashMap;

/**
 * 难点在于 随机指针 需要在 节点产生 后进行维护
 * 本算法采用 哈希表进行维护
 */
public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        HashMap<Node, Node> copyMap = new HashMap<>();

        copyMap.put(head, newHead); // 手动维护头结点

        for (Node cur = head.next, curCopy = newHead; cur != null; cur = cur.next) {
            curCopy.next = new Node(cur.val);
            curCopy = curCopy.next;
            copyMap.put(cur, curCopy);
        }

        for (Node cur = head, curCopy = newHead; cur != null; cur = cur.next, curCopy = curCopy.next) {
            Node newRandom = copyMap.get(cur.random);
            curCopy.random = newRandom;
        }

        copyMap = null; // 清理内存，利于垃圾回收

        return newHead;
    }
}
