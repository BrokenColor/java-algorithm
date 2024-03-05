package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 160. 相交链表
 *
 * @author guwanli
 * @date 2022/1/5 19:51
 */
public class LC_160_S_GetIntersectionNode {
    public static void main(String[] args) {
        LC_160_S_GetIntersectionNode solution = new LC_160_S_GetIntersectionNode();
        //[4,1,8,4,5]
        //[5,6,1,8,4,5]
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        ListNode nodeB = new ListNode(6);
        headB.next = nodeB;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        headA.next = node1;
        nodeB.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(solution.getIntersectionNode(headA, headB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //先判断链表是否有交集
        ListNode pA = headA, pB = headB;
        while (pA.next != null || pB.next != null) {
            if (pA.next != null) pA = pA.next;
            if (pB.next != null) pB = pB.next;
        }
        if (pA != pB) {
            return null;
        }
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        return p1;
    }
}
