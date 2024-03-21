package algorithmCode.InterestingCode;

/**
 * 2671. 频率跟踪器
 *
 * @Author bc
 * @Date 2024/3/21 19:49
 * @Description: TODO
 */
public class LC_2671_M_FrequencyTracker {
    class FrequencyTracker {
        //数组长度
        final int N = 100001;
        //记录每个数字出现的次数
        //freq[i]表示数字i出现的次数
        int[] freq;
        //记录频率的次数
        int[] freqCnt;

        public FrequencyTracker() {
            freq = new int[N];
            freqCnt = new int[N];
        }

        public void add(int number) {
            //原来频次 的个数减1
            freqCnt[freq[number]]--;
            //number 出现的频次 +1
            freq[number]++;
            //新的频次 的个数+1
            freqCnt[freq[number]]++;
        }

        public void deleteOne(int number) {
            if (freq[number] == 0) return;
            //原来频次 的个数减1
            freqCnt[freq[number]]--;
            //number 出现的频次 -1
            freq[number]--;
            //新的频次 的个数+1
            freqCnt[freq[number]]++;
        }

        public boolean hasFrequency(int frequency) {
            //返回是否存在frequency个数字
            return freqCnt[frequency] > 0;
        }
    }
}
