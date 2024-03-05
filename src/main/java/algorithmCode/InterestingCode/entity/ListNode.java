package algorithmCode.InterestingCode.entity;

/**
 * node节点
 *
 * @author guwanli
 * @date 2021/12/28 10:29
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
