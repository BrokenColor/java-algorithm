package algorithmCode.InterestingCode;
/**
 * 134. 加油站
 *
 * @author bc
 * @date 2023/5/22 10:54
 */
public class LC_134_M_CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int i = 0;
        while (i < length) {
            //记录走了步数
            int step = 0;
            //总的油量，总的消耗
            int sumGas = 0, sumCost = 0;
            while (step < length) {
                //走的下个节点
                int index = (i + step) % length;
                //更新油量
                sumGas += gas[index];
                //更新油耗
                sumCost += cost[index];
                //如果总油量小于总油耗，说明无法到下个节点，则跳出
                if (sumGas < sumCost) {
                    break;
                }
                //向前走一步
                step++;
            }
            //如果步数等于数组长度，说明走了一圈，则返回i下标
            if (step == length) {
                return i;
            } else {
                //否则则直接跳到无法到达（本来油耗不够）的节点作为起点
                i = i + step + 1;
            }
        }
        return -1;
    }
}
