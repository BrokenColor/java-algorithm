package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 25.K个一组翻转链表
 *
 * @author bc
 * @date 2022/3/16 11:09
 */
public class LC_25_H_ReverseKGroup {
    public static void main(String[] args) {
        //head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        int k = 2;
        LC_25_H_ReverseKGroup solution = new LC_25_H_ReverseKGroup();
        ListNode node = solution.reverseKGroup(head, k);
        System.out.println("done");
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转a到b元素
        ListNode newHead = this.reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间链表
     * 反转区间 [a, b) 的元素，注意是左闭右开
     *
     * @param a（包含）
     * @param b（不包含）
     * @return
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode curNode = a, nextNode = a, preNode = null;

        while (curNode != b) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
