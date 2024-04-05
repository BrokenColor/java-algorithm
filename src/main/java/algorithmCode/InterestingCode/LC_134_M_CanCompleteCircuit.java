package algorithmCode.InterestingCode;

/**
 * 134. 加油站
 *
 * @author bc
 * @date 2023/5/22 10:54
 */
public class LC_134_M_CanCompleteCircuit {
    /**
     * 判断是否能够完成环形电路的行驶。
     *
     * @param gas  一个整数数组，表示每个加油站提供的油量。
     * @param cost 一个整数数组，表示从每个加油站出发到下一个加油站所需的油耗。
     * @return 如果能够完成环形行驶，返回起始站点的索引；否则返回-1。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int i = 0;
        while (i < length) {
            // 初始化步数和总油量、总油耗
            int step = 0;
            int sumGas = 0, sumCost = 0;
            // 尝试从当前节点开始行驶一圈
            while (step < length) {
                int index = (i + step) % length;
                // 更新油量和油耗
                sumGas += gas[index];
                sumCost += cost[index];
                // 如果油量不足以支持到下一个节点，则退出内层循环
                if (sumGas < sumCost) {
                    break;
                }
                step++;
            }
            // 如果步数等于数组长度，说明成功行驶了一圈
            if (step == length) {
                return i;
            } else {
                // 否则，将起点调整到无法继续行驶的节点之后一个节点
                i = i + step + 1;
            }
        }
        // 如果无法找到能够完成行驶的起点，返回-1
        return -1;
    }

}
