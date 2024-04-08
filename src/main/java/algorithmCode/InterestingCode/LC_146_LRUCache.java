package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146.LRUCache
 *
 * @Author bc
 * @Date 2024/2/19 15:21
 * @Description: LRUCache
 */
public class LC_146_LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    //头节点，方便链表操作
    private DLinkedNode head;

    //头节点，方便链表操作
    private DLinkedNode tail;
    private int capacity;

    public LC_146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        //移动到头部
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            addHead(node);
            cache.put(key, node);
            if (cache.size() > capacity) {
                int deleteKey = removeTail();
                cache.remove(deleteKey);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addHead(DLinkedNode node) {
        if (node == null) return;
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        if (node == null) return;
        //删除节点
        deleteNode(node);
        //添加到头
        addHead(node);
    }

    private int removeTail() {
        if (head.next == tail) return -1;
        int key = tail.pre.key;
        //删除尾部node
        deleteNode(tail.pre);
        return key;
    }

    private void deleteNode(DLinkedNode node) {
        if (node == null) return;

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class DLinkedNode {
    public DLinkedNode pre;
    public DLinkedNode next;
    public int key;
    public int value;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}