package lib_use;

public class LRU_Basic {
    private MyList myList;
    // 手动实现 LRU。思路如下: 采用链表，新输入插入到头部，访问某个结点后将移动到头部。删除时删除尾部。
    public LRU_Basic() {

    }
    public int get() {
        return 0;
    }
    public void set(int node) {

    }
}

class MyList {
    private Node head, tail;
    private Node emptyNode = new Node();
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    public MyList() {
        this.head = null;
        this.tail = null;

        this.emptyNode.key = -1;
        this.emptyNode.next = null;
        this.emptyNode.value = -1;
    }
    public Node NodeFactory(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        node.next = null;
        return node;
    }
    public int ParseNode(Node node) {
        return node.value;
    }
    public void AddHead(Node node) {
        node.next = head;
        head = node;
        if (head.next == null) {
            tail = head;
        }
    }
    public Node GetNode(int key) {
        Node save = head;
        for (Node node = head; node != null; node = node.next) {
            if(node.key == key) {
                if (node.next == null) {
                    tail = save;
                }
                save.next = node.next;
                node.next = head;
                head = node;
                return node;
            }
            save = node;
        }
        return emptyNode;
    }
    public void RemoveTail() {
        // 需要维护一个双向链表

    }
}