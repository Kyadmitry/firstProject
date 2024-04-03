public class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 9}, 4));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int medium = left + (right - left) / 2;
            if (nums[medium] == target) {
                return medium;
            } else if (nums[medium] > target) {
                right = medium - 1;
            } else if (nums[medium] < target) {
                left = medium + 1;
            }
        }
        return -1;
    }

}


