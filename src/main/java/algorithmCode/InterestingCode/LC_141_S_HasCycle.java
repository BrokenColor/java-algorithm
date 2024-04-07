package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 141.环形链表
 *
 * @author bc
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
     * 检查给定的链表是否包含环。
     * 使用快慢指针的方法，快指针每次移动两步，慢指针每次移动一步。
     * 如果链表中存在环，那么快慢指针最终会相遇；如果没有环，则快指针会先到达链表尾部。
     *
     * @param head 链表的头节点。类型为ListNode，表示链表的起始节点。
     * @return 返回一个布尔值，如果链表中存在环则返回true，否则返回false。
     */
    public boolean hasCycle(ListNode head) {
        // 链表为空或只有一个节点时不可能存在环
        if (head == null || head.next == null) return false;

        // 初始化快慢指针
        ListNode fast = head.next, low = head;

        // 使用快慢指针遍历链表，检查是否存在环
        while (fast != low) {
            // 如果快指针或其下一个节点为空，则链表无环
            if (fast == null || fast.next == null) return false;

            // 快指针每次移动两步，慢指针每次移动一步
            fast = fast.next.next;
            low = low.next;
        }

        // 若快慢指针相遇，则链表存在环
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
