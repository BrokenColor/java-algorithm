package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 86 分隔链表
 *
 * @author bc
 * @date 2023/2/16 16:40
 */
public class LC_86_M_Partition {

    public static void main(String[] args) {
        LC_86_M_Partition solution = new LC_86_M_Partition();
        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode head = new ListNode(1, node1);

        solution.partition(head, 3);
    }

    public ListNode partition(ListNode head, int x) {
        //临时头节点
        ListNode dummy1 = new ListNode(-1);
        //临时头节点
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2, p = head;
        //将一个链表拆成两个
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            //断开原链表中的next节点
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        //连接两个链表
        p1.next = dummy2.next;
        return dummy1;
    }
}
