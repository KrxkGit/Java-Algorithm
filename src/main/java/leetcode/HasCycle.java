package leetcode;


import java.util.HashSet;

public class HasCycle {
    /**
     * 由于 ListNode 没有 改写 hashCode 函数，故 哈希值 与内存地址有关
     * 故可使用哈希集合判断是否已经访问
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (hashSet.contains(cur)) {
                return true;
            }
            hashSet.add(cur);
        }

        return false;
    }

    /**
     * 快慢指针法，如果存在环，快慢指针必然相遇
     * @param head
     * @return
     */
    public boolean hasCyclePlus(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null || slow.next == null || fast.next == null || fast.next.next == null) {
                // 抵达末尾
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
