package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 *
 * @Author bc
 * @Date 2023/5/19 22:56
 * @Description: TODO
 */
public class LC_380_M_RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;

    Random random;

    public LC_380_M_RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        map.put(val, index);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int size = list.size();
        Integer last = list.get(size - 1);
        Integer valIndex = map.get(val);
        map.remove(valIndex);
        list.remove(size - 1);
        map.put(last, valIndex);
        list.set(valIndex, last);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
