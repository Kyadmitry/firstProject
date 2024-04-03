package no_name;

import java.util.*;

public class TreeClass {
    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[] {4, 2, 2, 1, 2, -3, 5, -8}, 5));
//        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{2, 6}, {1, 8}, {8, 10}, {15, 18}})));
        System.out.println(subarray("dvdf"));
        System.out.println(subarray("abcasdfr"));
        System.out.println(subarray("bbbbbb"));
        System.out.println(subarray(""));
        System.out.println(subarray("abcabcbca"));

    }

    private static int subarray(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        while (left <= right) {
            if (set.contains(chars[]))
        }
    }


    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftSum = dfs(root.left);
        int maxRightSum = dfs(root.right);
        return Math.max(maxLeftSum, maxRightSum) + root.val;
    }


    private static int subarraySum(int[] nums, int target) {
        int result = 0;
        int subarraySum = 0;
        Map<Integer, Integer> sumToCount = new HashMap<>(Map.of(0, 1));

        for (int num: nums) {
            subarraySum += num;
            int partlySum = subarraySum - target;
            Integer count = sumToCount.get(partlySum);
            if (count != null) {
                result += count;
            }
            Integer prevCount = sumToCount.get(subarraySum);
            prevCount = prevCount != null ? prevCount : 0;
            sumToCount.put(subarraySum, prevCount + 1);
        }

        return result;
    }


    private int subarraySum2(int[] nums, int target) {
        int result = 0;
        Map<Integer, Integer> sumToCount = new HashMap<>();

        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int partlySum = target - currentSum;
            int count = sumToCount.get(partlySum);
            result += count;
            currentSum += nums[i];

            sumToCount.put(partlySum, sumToCount.get(nums[i]) + 1);
        }
        return result;
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for(int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}

class TreeNode {
    int val;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}