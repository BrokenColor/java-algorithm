package algorithmCode.InterestingCode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705.设计哈希集合
 *
 * @Author bc
 * @Date 2024/4/14 18:08
 * @Description: 哈希
 */
public class LC_705_S_MyHashSet {

    /**
     * 直接用数组
     */
    class MyHashSet1 {
        private int[] setArr;
        private int n = 1000001;

        public MyHashSet1() {
            setArr = new int[n];
        }

        public void add(int key) {
            setArr[key] = 1;
        }

        public void remove(int key) {
            setArr[key] = 0;
        }

        public boolean contains(int key) {
            return setArr[key] == 1;
        }
    }

    /**
     * 模拟hash  数组+链表
     * 时间换空间
     */
    class MyHashSet {
        //默认数组长度
        private static final int BASE = 769;
        //存储数据数组链表
        private LinkedList<Integer>[] data;

        public MyHashSet() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList();
            }
        }

        /**
         * 向数据结构中添加一个指定的键值。
         * 注：此方法假设数据结构为一种基于哈希的集合，具体实现细节未展示。
         *
         * @param key 需要添加的键值。
         */
        public void add(int key) {
            // 根据键值计算哈希值，并定位到相应的数组索引
            int index = hash(key);
            Iterator<Integer> iterator = data[index].iterator();
            // 遍历该索引位置的链表，检查是否已存在相同的键值
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    // 如果键值已存在，则直接返回，不进行重复添加
                    return;
                }
            }
            // 如果键值不存在，则将键值添加到该索引位置的链表末尾
            data[index].offerLast(key);
        }

        /**
         * 从哈希表中移除指定的键值。
         *
         * @param key 需要被移除的键值。
         */
        public void remove(int key) {
            // 根据键值计算哈希值，并定位到相应的桶
            int index = hash(key);
            Iterator<Integer> iterator = data[index].iterator();
            // 遍历桶中的元素，查找与给定键值相等的元素
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    // 找到相等的键值后，将其从集合中移除
                    iterator.remove();
                    return;
                }
            }
        }


        /**
         * 检查集合中是否包含指定的键。
         *
         * @param key 需要检查的键。
         * @return 如果集合中包含该键，则返回 true；否则返回 false。
         */
        public boolean contains(int key) {
            // 根据键计算哈希值，以确定其在数据结构中的位置
            int index = hash(key);
            Iterator<Integer> iterator = data[index].iterator();
            // 遍历该位置上的所有元素，检查是否存在与键相等的元素
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    return true; // 如果找到相等的键，则返回 true
                }
            }
            return false; // 遍历完所有元素后仍未找到相等的键，返回 false
        }


        /**
         * 根据键值计算哈希值。
         *
         * @param key 输入的键值。
         * @return 哈希值，为键值除以BASE的余数。
         */
        int hash(int key) {
            // 使用取模运算计算哈希值
            return key % BASE;
        }
    }
}
