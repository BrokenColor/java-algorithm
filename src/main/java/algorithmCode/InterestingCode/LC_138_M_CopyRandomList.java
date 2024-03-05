package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138.复制带随机指针的链表
 */
public class LC_138_M_CopyRandomList {
    //缓存已经创建的node
    Map<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cache.containsKey(head)) {
            //复制节点
            Node node = new Node(head.val);
            cache.put(head, node);
            //递归处理下一级
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }
}
