package algorithmCode.InterestingCode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706.设计哈希映射
 *
 * @Author bc
 * @Date 2024/4/15 23:15
 * @Description: 数组 哈希
 */
public class LC_706_S_MyHashMap {

    class MyHashMap {
        private static final int BASE = 769;
        //存储数据数组链表
        private LinkedList[] data;

        public MyHashMap() {
            data = new LinkedList[BASE];
            for (int i = 0; i < data.length; i++) {
                data[i] = new LinkedList<>();
            }
        }

        public void put(int key, int value) {
            int index = hash(key);
            Iterator iterator = data[index].iterator();
            while (iterator.hasNext()) {
                int[] next = (int[]) iterator.next();
                if (next[0] == key) {
                    iterator.remove();
                }
            }
            data[index].offer(new int[]{key, value});
        }

        public int get(int key) {
            int index = hash(key);
            Iterator iterator = data[index].iterator();
            while (iterator.hasNext()) {
                int[] next = (int[]) iterator.next();
                if (next[0] == key) {
                    return next[1];
                }
            }
            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            Iterator iterator = data[index].iterator();
            while (iterator.hasNext()) {
                int[] next = (int[]) iterator.next();
                if (next[0] == key) {
                    iterator.remove();
                }
            }
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
