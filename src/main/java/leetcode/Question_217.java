package leetcode;

import java.util.*;

/**
 * @author zhangtengfei
 * @Date 2022/12/27 23:09
 * @since 1.0
 */
public class Question_217 {
    public static void main(String[] args) {
        new TestCase().test(new Solution());
    }

    private static class TestCase {
        Map<int[], Boolean> testCases = Map.of(
                new int[]{1,2,3,1}, true,
                new int[]{1,2,3,4}, false,
                new int[]{1,1,1,3,3,4,3,2,4,2}, true
        );

        void test(Solution solution) {
            testCases.forEach((testCase, expect) -> System.out.println(solution.containsDuplicate(testCase) == expect));
        }
    }

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            int length = nums.length;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                if (!set.add(nums[i])) return true;
            }
            return false;
        }
    }
}
