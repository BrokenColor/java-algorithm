package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 142. 环形链表 II
 *
 * @author guwanli
 * @date 2022/1/5 17:28
 */
public class LC_142_M_DetectCycle {
    public static void main(String[] args) {
        LC_142_M_DetectCycle solution = new LC_142_M_DetectCycle();
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(solution.detectCycle(node));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        //定义两个指针
        ListNode fast = head, slow = head;
        //快指针走完都没有重合说明没有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        // 重新指向头结点
        slow = head;
        // 快慢指针同步前进，相交点就是环起点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
