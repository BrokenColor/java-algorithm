package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 160. 相交链表
 *
 * @author bc
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

    /**
     * 获取两个链表的交点
     * @param headA 第一个链表的头结点
     * @param headB 第二个链表的头结点
     * @return 两个链表的交点；如果没有交点，返回null。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先判断链表是否有交集
        ListNode pA = headA, pB = headB;
        while (pA.next != null || pB.next != null) {
            if (pA.next != null) pA = pA.next;
            if (pB.next != null) pB = pB.next;
        }
        // 如果遍历结束pA和pB不相等，则链表没有交集
        if (pA != pB) {
            return null;
        }

        // 使用双指针法找到交点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1遍历完A链表后转到B链表
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            // p2遍历完B链表后转到A链表
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        // 返回交点结点
        return p1;
    }
}
