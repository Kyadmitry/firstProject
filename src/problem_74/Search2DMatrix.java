package problem_74;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(searchMatrix(matrix2, 7));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int leftPtr = 0;
        int rightPtr = rowLength * colLength - 1;

        while (leftPtr <= rightPtr) {
            int middle = (rightPtr + leftPtr) / 2;
            int current = matrix[middle / colLength][middle % colLength];

            if (current > target) {
                rightPtr = middle - 1;
            } else if (current < target) {
                leftPtr = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
