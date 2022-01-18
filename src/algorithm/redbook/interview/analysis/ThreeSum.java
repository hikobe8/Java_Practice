package algorithm.redbook.interview.analysis;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3-SUM in quadratic time
 */
public class ThreeSum {

    public int count(int[] nums){
        //make array increase
        Arrays.sort(nums);
        Map<Integer, Integer> kv = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            kv.put(nums[i], i);
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= 0) {
                    break; //数组是升序的，前面的两数之和为正数，其中后一个数必定为正数，所以第三个数也必定为更大的正数
                }
                Integer index = kv.get(-sum);//find the third num , num + sum == 0
                if (index != null && index > j) {
                    StdOut.println(nums[i] + "," + nums[j] + "," + nums[index]);
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] a = { 30, -40, -20, -10, 40, 0, 10, 5 };
        StdOut.println(threeSum.count(a));
    }

}
