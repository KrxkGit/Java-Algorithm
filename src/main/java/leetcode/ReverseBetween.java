package leetcode;

/**
 * 可采用虚拟头结点
 * 注意 切割出变换与静止的部分
 * next 指针 的本质 即是 箭头： A -> B 表示 A.next = B; 调整 next 指针的本质就是调整箭头
 * while 循环 可转换为 for 循环理解
 */

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int saveLeft = left;
        ListNode virtualHead = new ListNode(-1, head); // 使用虚拟头结点，避免分类讨论头指针
        ListNode leftNode, rightNode, before = null, after;
        ListNode cur = virtualHead;
        left += 1; // 调整虚拟头结点
        while (--left > 0) {
            before = cur;
            cur = cur.next;
        }
        leftNode = cur;
        System.out.printf("left: %d\n", leftNode.val);

        int continueWalk = right - saveLeft + 1; // 此处使用长度
        System.out.printf("left: %d right:%d continueWalk: %d\n", saveLeft, right, continueWalk);
        while (--continueWalk > 0) {
            cur = cur.next;
        }
        rightNode = cur;
        System.out.printf("right: %d\n", rightNode.val);

        after = cur.next;
        System.out.printf("before: %d after: %d\n", before.val, after == null ? -1 : after.val);
        reverseBetween(leftNode, rightNode, before, after);

        cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.val);
            cur = cur.next;
        }
        return virtualHead.next;
    }

    private void reverseBetween(ListNode left, ListNode right, ListNode before, ListNode after) {
        ListNode cur = left;
        ListNode pre = before;
        while (cur != null && cur != after) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        before.next = right;
        left.next = after;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}