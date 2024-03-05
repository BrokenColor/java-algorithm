package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 752 打开转盘锁
 * BFS(广度优先搜索)
 *
 * @author bc
 * @date 2021/10/15 8:05 下午
 */
public class LC_752_M_OpenLock {

    //输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    //输出：6
    public static void main(String[] args) {
        LC_752_M_OpenLock openLock = new LC_752_M_OpenLock();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int result = openLock.openLock(deadends, target);
        System.out.println(result);
    }

    public int openLock(String[] deadends, String target) {
        LinkedList<String> queue = new LinkedList();
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        //记录已访问的节点
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        queue.add("0000");
        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //当层遍历
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                //是否死锁
                if (deadendSet.contains(s)) {
                    continue;
                }
                //找到结果
                if (s.equals(target)) return path;
                //四位密码处理
                for (int j = 0; j < 4; j++) {
                    //向上处理
                    String up = up(s, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    //闲暇
                    String down = down(s, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            path++;
        }

        return -1;
    }

    /**
     * trun up
     *
     * @param s
     * @return
     */
    public String up(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    /**
     * trun down
     *
     * @param s
     * @return
     */
    public String down(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

}
