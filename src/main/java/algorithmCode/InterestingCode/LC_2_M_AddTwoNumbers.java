package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 2. 两数相加
 *
 * @Author bc
 * @Date 2023/3/11 12:17
 * @Description: 链表
 */
public class LC_2_M_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode p = l1, q = l2, curr = listNode;
        //记录进位
        int carry = 0;
        while (p != null || q != null) {
            //获取节点值
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            //计算节点和
            int sum = carry + x + y;
            //更新进位
            carry = sum / 10;
            //记录节点值
            curr.next = new ListNode(sum % 10);
            //修改当前节点指针
            curr = curr.next;
            //节点后移
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //如果还有进位未处理，添加节点
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        //返回节点（头节点为空）
        return listNode.next;
    }
}
