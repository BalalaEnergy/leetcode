package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangtengfei
 * @Date 2022/12/27 22:43
 * @since 1.0
 */
public class Question_53 {
    public static void main(String[] args) {
        new TestCase().test(new Solution());
    }

    private static class TestCase {
        Map<Integer[], Integer> testCases = Map.of(
                new Integer[]{-2,1,-3,4,-1,2,1,-5,4}, 6,
                new Integer[]{1}, 1,
                new Integer[]{5,4,-1,7,8}, 23
        );

        void test(Solution solution) {
            testCases.forEach((testCase, expect) -> System.out.println(solution.maxSubArray(testCase) == expect));
        }
    }

    private static class Solution {
        public int maxSubArray(Integer[] nums) {
            // dp用于存放以当前元素结尾的连续子数组的最大和
            int[] dp = new int[nums.length];
            // 以第一个元素结尾的连续子数组的最大和就是数组的第一个元素
            dp[0] = nums[0];
            // 返回结果 初始化为dp[0]
            int result = dp[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] < 0) {
                    // 如果dp[i - 1] < 0, 则以当前元素结尾的连续子数组的最大和就是当前元素
                    dp[i] = nums[i];
                } else {
                    // 如果dp[i - 1] > 0, 则以当前元素结尾的连续子数组的最大和就是当前元素 + dp[i - 1]
                    dp[i] = dp[i - 1] + nums[i];
                }
                // 如果dp[i] > result, 则当前数组的连续子数组的最大和为dp[i]
                result = Math.max(dp[i], result);
            }
            return result;
        }
    }
}
