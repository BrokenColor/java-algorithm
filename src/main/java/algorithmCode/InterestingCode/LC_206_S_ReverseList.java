package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 206.反转链表
 *
 * @Author bc
 * @Date 2023/3/12 16:48
 */
public class LC_206_S_ReverseList {
    /**
     * 反转链表。
     *
     * @param head 链表的头节点。
     * @return 反转后的链表的头节点。
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, next;
        while (curr != null) {
            // 保存当前节点的下一个节点，以便后续处理
            next = curr.next;
            // 将当前节点的next指针指向前一个节点，实现节点反转
            curr.next = pre;
            // 更新前一个节点为当前节点，准备处理下一个节点
            pre = curr;
            // 将当前节点指向下一个节点，继续遍历
            curr = next;
        }
        return pre; // 返回反转后的链表的头节点
    }
}
