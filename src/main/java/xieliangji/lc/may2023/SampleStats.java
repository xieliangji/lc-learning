package xieliangji.lc.may2023;

import java.util.ArrayList;
import java.util.List;

/**
 * 难易程度: 中等
 * 题目描述:
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 在样本中出现的次数。
 * <p>
 * 计算以下统计数据:
 * <p>
 * minimum ：样本中的最小元素。
 * maximum ：样品中的最大元素。
 * mean ：样本的平均值，计算为所有元素的总和除以元素总数。
 * median ：
 * 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
 * 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
 * mode ：样本中出现次数最多的数字。保众数是 唯一 的。
 * 以浮点数数组的形式返回样本的统计信息 [minimum, maximum, mean, median, mode] 。与真实答案误差在 10-5 内的答案都可以通过
 */
public class SampleStats {

    // original - timeout
    public static double[] sampleStats(int[] count) {
        double[] result = new double[]{256, 0, 0, 0, 0}; // min/max/mean/median/mode
        List<Double> samples = new ArrayList<Double>();
        double sum = 0;
        for (int index = 0; index < count.length; index++) {
            if (count[index] == 0) {
                continue;
            }
            // min
            if (result[0] > index) {
                System.out.printf("result: %s, count: %s%n", result[0], count[index]);
                result[0] = index;
            }
            // max
            result[1] = index;
            // mode
            if (count[index] > count[(int) result[4]]) {
                result[4] = index;
            }

            for (int j = 0; j < count[index]; j++) {
                samples.add((double) index);
            }
            sum += index * count[index];
        }
        int size = samples.size();
        // mean
        result[2] = sum / size;
        // median
        result[3] = size % 2 != 0 ? samples.get(size / 2) : (samples.get(size /2) + samples.get(size / 2 - 1)) / 2;

        return result;
    }

    // opt
    public static double[] sampleStatsOpt(int[] count) {
        int len = count.length;
        int min = 256, max = 0, mode = 0, median = 0, sum = 0, nums = 0;

        for (int index = 0; index < len; index++) {
            nums += count[index];
            sum += index * count[index];
        }
        double mean = ((double) sum) / nums;
        int left = (nums + 1) / 2;
        int right = (nums + 2) / 2;

        int traversed = 0;
        for (int index = 0; index < len; index++) {
            if (count[index] > 0) {
                if (index < min) {
                    min = index;
                }
                max = index;
            }
            if (count[index] > mode) {
                mode = index;
            }
            if (traversed < right && (traversed + count[index]) >= (right + 1)) {
                median += index;
            }
            if (traversed < left && (traversed + count[index]) >= (left + 1)) {
                median += index;
            }
            traversed += count[index];
        }

        return new double[]{min, max, mean, median / 2.0, mode};
    }
}
