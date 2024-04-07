package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 142. 环形链表 II
 *
 * @author bc
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

    /**
     * 检测链表中是否存在环，并返回环的起始节点。
     *
     * @param head 链表的头节点
     * @return 如果链表中存在环，则返回环的起始节点；如果不存在环，则返回null。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null; // 若链表为空或只有一个节点，则不存在环，直接返回null
        // 定义两个指针，一个快指针，一个慢指针，初始都指向头节点
        ListNode fast = head, slow = head;
        // 使用快慢指针法判断链表是否存在环
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针每次移动两步
            slow = slow.next; // 慢指针每次移动一步
            if (fast == slow) break; // 如果快慢指针相遇，则说明链表存在环
        }
        if (fast == null || fast.next == null) return null; // 如果快指针或其下一个节点为null，说明链表不存在环，返回null

        // 重新将慢指针指向头节点，然后快慢指针同时向前移动，直到相遇，相遇点即为环的起始节点
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow; // 返回环的起始节点
    }
}
