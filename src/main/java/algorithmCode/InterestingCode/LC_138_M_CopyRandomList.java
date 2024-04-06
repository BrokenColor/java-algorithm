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

    /**
     * 复制一个带有随机指针的链表。链表中的每个节点除了有一个指向下一个节点的指针（next）外，还有一个指向链表中任一个节点或null的随机指针（random）。
     *
     * @param head 原始链表的头节点
     * @return 复制链表的头节点
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cache.containsKey(head)) {
            // 复制节点并建立原节点到复制节点的映射
            Node node = new Node(head.val);
            cache.put(head, node);
            // 递归处理下一级节点的复制
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return cache.get(head); // 返回复制链表中的对应节点
    }
}
