package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 82.删除排序链表中的重复元素 II
 *
 * @Author bc
 * @Date 2023/8/25 10:58
 * @Description: 链表
 */
public class LC_82_M_DeleteDuplicates {

    public static void main(String[] args) {
        //head = [1,2,3,3,4,4,5]
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node22 = new ListNode(3);
        node2.next = node22;
        ListNode node3 = new ListNode(4);
        node22.next = node3;
        ListNode node33 = new ListNode(4);
        node3.next = node33;
        ListNode node4 = new ListNode(5);
        node33.next = node4;
        LC_82_M_DeleteDuplicates solution = new LC_82_M_DeleteDuplicates();
        ListNode listNode = solution.deleteDuplicates(head);
        //输出
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(-101);
        ListNode curNode = head, p = dump;
        while (curNode != null) {
            boolean flag = false;
            ListNode nextNode = curNode.next;
            while (nextNode != null && curNode.val == nextNode.val) {
                nextNode = nextNode.next;
                flag = true;
            }
            //判断是否重复元素标识
            if (!flag) {
                p.next = new ListNode(curNode.val);
                p = p.next;
            }
            //跳到下一个节点
            curNode = nextNode;
        }
        return dump.next;
    }
}
