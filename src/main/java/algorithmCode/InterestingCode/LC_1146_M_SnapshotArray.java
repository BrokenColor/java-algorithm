package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1146.快照数组
 *
 * @Author bc
 * @Date 2024/4/27 21:20
 * @Description: 数组
 */
public class LC_1146_M_SnapshotArray {

    public static void main(String[] args) {
        LC_1146_M_SnapshotArray lc1146MSnapshotArray = new LC_1146_M_SnapshotArray();
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        System.out.println(snapshotArray.snap());
        snapshotArray.set(0, 6);
        System.out.println(snapshotArray.get(0, 0));
    }


    static class SnapshotArray {
        private int snapshotId;
        private Map<Integer, TreeMap<Integer, Integer>> coll;

        public SnapshotArray(int length) {
            snapshotId = 0;
            coll = new HashMap<>(length);
        }

        public void set(int index, int val) {
            coll.computeIfAbsent(index, k -> new TreeMap<>()).put(snapshotId, val);
        }

        public int snap() {
            return snapshotId++;
        }

        public int get(int index, int snap_id) {
            Map.Entry<Integer, Integer> entry =
                    coll.computeIfAbsent(index, k -> new TreeMap<>()).floorEntry(snap_id);
            return entry == null ? 0 : entry.getValue();
        }
    }
}
