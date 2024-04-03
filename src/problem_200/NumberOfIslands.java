package problem_200;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int islandsCount = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    islandsCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandsCount;
    }

    private static void dfs(char[][] grid, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        grid[row][col] = '2';

        if (row > 0 && grid[row - 1][col] == '1') {
            dfs(grid, row - 1, col);
        }
        if (col > 0 && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1);
        }
        if (row < rowLength - 1 && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col);
        }
        if (col < colLength - 1 && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1);
        }
    }
}
