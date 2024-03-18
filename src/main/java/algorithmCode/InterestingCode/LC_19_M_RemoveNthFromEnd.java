package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 19.删除链表的倒数第 N 个结点
 * @date 2022/2/17 15:41
 */
public class LC_19_M_RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        int n = 2;
        LC_19_M_RemoveNthFromEnd solution = new LC_19_M_RemoveNthFromEnd();
        solution.removeNthFromEnd(head, n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode node = findNode(dummy, n + 1);
        // 删掉倒数第 n 个节点
        node.next = node.next.next;

        return dummy.next;
    }

    /**
     * // 返回链表的倒数第 N 个节点
     *
     * @param head 头节点
     * @param n
     * @return
     */
    private ListNode findNode(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        // p1 先走 k 步
        for (int i = 0; i < n; i++) {
            if (p1 != null) {
                p1 = p1.next;
            }
        }
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
