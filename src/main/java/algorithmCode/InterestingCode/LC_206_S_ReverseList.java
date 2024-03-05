package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 206.反转链表
 *
 * @Author bc
 * @Date 2023/3/12 16:48
 */
public class LC_206_S_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, next;
        while (curr != null) {
            //存储下一个节点的指针，否则修改完节点指针就找不到下一个节点了
            next = curr.next;
            //指针修改：把前置节点赋值给当前节点的next
            curr.next = pre;
            //把处理完的节点存到pre节点上
            pre = curr;
            //处理下一个节点
            curr = next;
        }
        return pre;
    }
}
