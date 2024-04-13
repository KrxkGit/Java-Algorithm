package leetcode;

/**
 * 采用归并排序
 * 代码目前存在 bug
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 查找中间值

        ListNode fast = head, slow = head, left = head, right, pre = head;
        while (true) {
            pre = slow;
            if (pre == null) {
                break;
            }
            slow = slow.next;
            if (fast == null) {
                break;
            } else {
                fast = fast.next;
            }
        }
        right = slow;
        pre.next = null;


        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        ListNode result = new ListNode(-1, null); // 虚拟头结点
        ListNode saveResult = result;
        while (true) {
            if (sortedLeft != null && sortedRight != null) {
                if (sortedLeft.val < sortedRight.val) {
                    result.next = sortedLeft;
                    sortedLeft = sortedRight.next;
                } else {
                    result.next = sortedRight;
                    sortedRight = sortedRight.next;
                }
            } else if (sortedLeft == null && sortedRight == null) {
                break;
            } else if (sortedLeft == null) {
                result.next = sortedRight;
                sortedRight = sortedRight.next;
            } else {
                result.next = sortedLeft;
                sortedLeft = sortedLeft.next;
            }
            result = result.next;
        }

        return saveResult.next;
    }
}
