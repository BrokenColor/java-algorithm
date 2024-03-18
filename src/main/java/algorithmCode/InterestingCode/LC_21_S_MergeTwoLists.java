package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * @author bc
 * @date 2021/12/28 10:28
 */
public class LC_21_S_MergeTwoLists {
    public static void main(String[] args) {
        LC_21_S_MergeTwoLists solution = new LC_21_S_MergeTwoLists();
        ListNode list1 = new ListNode(1);
        ListNode t1 = new ListNode(2);
        list1.next = t1;
        ListNode t2 = new ListNode(4);
        t1.next = t2;

        ListNode list2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        list2.next = t3;
        ListNode t4 = new ListNode(4);
        t2.next = t4;
        solution.mergeTwoLists(list1, list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(-1);
        ListNode p = listNode, p1 = list1, p2 = list2;
        //双指针在两个链表上移动
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        p.next = p1 == null ? p2 : p1;
        return listNode.next;
    }

    /**
     * 递归
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }
}
