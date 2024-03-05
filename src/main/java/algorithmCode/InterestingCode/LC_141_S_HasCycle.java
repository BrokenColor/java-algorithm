package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 141.环形链表
 *
 * @author guwanli
 * @date 2022/1/5 17:29
 */
public class LC_141_S_HasCycle {
    public static void main(String[] args) {
        LC_141_S_HasCycle solution = new LC_141_S_HasCycle();
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(solution.hasCycle(node));
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        //定义两个指针
        ListNode fast = head.next, low = head;
        while (fast != low) {
            //快指针走完都没有重合说明没有环
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            low = low.next;
        }
        return true;
    }

    public boolean hasCycle1(ListNode head) {
        ListNode fast = head, low = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            if (fast == low){
                return true;
            }
        }
        return false;
    }
}
