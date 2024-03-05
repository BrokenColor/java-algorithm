package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 49.字母异位词分组
 */
public class LC_49_M_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        LC_49_M_GroupAnagrams solution = new LC_49_M_GroupAnagrams();
        System.out.println(solution.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //记录相同key 的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            //字符串排序，构建key
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            //存入map中
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
