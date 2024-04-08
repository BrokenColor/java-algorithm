package algorithmCode.InterestingCode;

import java.util.*;

/**
 * 1600.王位继承顺序
 *
 * @Author bc
 * @Date 2024/4/7 23:13
 * @Description: 多叉树前序遍历
 */
public class LC_1600_M_ThroneInheritance {
    public static void main(String[] args) {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        System.out.println(throneInheritance.getInheritanceOrder());
    }
}

/**
 * 宫廷继承类，用于管理和记录一个皇室家族的成员及其继承关系。
 */
class ThroneInheritance {
    // 存储家族成员之间继承关系的图，用邻接表表示
    Map<String, List<String>> edges;
    // 记录已经逝世的成员
    Set<String> deads;
    // 皇室家族的创始人或现任君主
    String king;

    /**
     * 构造函数，初始化皇室继承系统。
     *
     * @param kingName 君主的名字。
     */
    public ThroneInheritance(String kingName) {
        edges = new HashMap<>();
        deads = new HashSet<>();
        king = kingName;
    }

    /**
     * 添加一个新成员到继承系统中，表示某成员有了子嗣。
     *
     * @param parentName 父亲的名字。
     * @param childName  子女的名字。
     */
    public void birth(String parentName, String childName) {
        List<String> childs = edges.getOrDefault(parentName, new ArrayList<>());
        childs.add(childName);
        edges.put(parentName, childs);
    }

    /**
     * 标记一个成员为逝世。
     *
     * @param name 逝世成员的名字。
     */
    public void death(String name) {
        deads.add(name);
    }

    /**
     * 获取整个皇室家族的继承顺序。
     *
     * @return 继承顺序的列表。
     */
    public List<String> getInheritanceOrder() {
        ArrayList<String> ans = new ArrayList<>();
        preorder(king, ans); // 通过前序遍历获取继承顺序
        return ans;
    }

    /**
     * 前序遍历皇室家族成员，构造继承顺序。
     *
     * @param name 当前遍历的成员名字。
     * @param ans  继承顺序的积累。
     */
    private void preorder(String name, List<String> ans) {
        if (!deads.contains(name)) { // 如果成员未逝世，则添加到继承顺序中
            ans.add(name);
        }
        List<String> childs = edges.getOrDefault(name, new ArrayList<>());
        for (String child : childs) { // 递归遍历子成员
            preorder(child, ans);
        }
    }
}

