package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 *
 * @author bc
 * @date 2022/1/6 20:30
 */
public class LC_23_H_MergeKLists {
    public static void main(String[] args) {
        LC_23_H_MergeKLists solution = new LC_23_H_MergeKLists();
        ListNode[] ListNodes = {};
        solution.mergeKLists(ListNodes);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //priorityQueue
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val));
        //head add PriorityQueue
        for (ListNode listNode : lists) {
            if (listNode != null) priorityQueue.add(listNode);
        }
        while (!priorityQueue.isEmpty()) {
            //priorityQueue poll min node
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            //node.next add priorityQueue
            if (poll.next != null) priorityQueue.add(poll.next);

            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }
}
