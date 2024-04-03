package problem_118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate2(5));
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }

    public static List<Integer> generateRow(int n) {
        List<Integer> arr = new ArrayList<>();

        int ans = 1;
        arr.add(ans);

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;

            arr.add(ans);
        }
        return arr;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> currentList = List.of(1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> nextLine = createNextTriangleLine(currentList);
            resultList.add(currentList);
            currentList = nextLine;
        }
        return resultList;
    }

    private static List<Integer> createNextTriangleLine(List<Integer> currentLine) {
        List<Integer> nextLine = new ArrayList<>();
        nextLine.add(currentLine.get(0));
        for (int i = 1; i < currentLine.size(); i++) {
            nextLine.add(currentLine.get(i - 1) + currentLine.get(i));
        }
        nextLine.add(currentLine.get(currentLine.size() - 1));
        return nextLine;
    }
}
