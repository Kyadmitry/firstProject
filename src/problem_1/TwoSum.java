package problem_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 9, 4, 2};
//        int[] nums = {2, 3, 4, 9};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        System.out.println(Arrays.toString(twoSumBest(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(target - current)) {
                return new int[] {i, map.get(target - current)};
            }
            map.put(current, i);
        }
        return new int[0];
    }

    public static int[] twoSumBest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                return new int[] {left, right};
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}
