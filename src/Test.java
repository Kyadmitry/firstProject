
import kotlin.test.Asserter;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        List list = new ArrayList(); // 1
        list.add("foo"); // 2
        Object o  = list.get(0); // 3
        String foo = (String) o; // 4

        list.add(0, 1); // 5
        Object oo = list.get(0); // 6
        String bar = (String) oo; // 7

//        int[] numsA = {1, 2, 4, 5};
//        int[] numsB = {3, 3, 4};
//
//        if (numsA[0] > numsB[0]) {
//
//        }
//
//
////        System.out.println(fib2(10));
//
//        TreeNode treeNode = new TreeNode(20,
//                new TreeNode(7,
//                        new TreeNode(4, null, null),
//                        new TreeNode(9, new TreeNode(87, null, null), null)),
//                new TreeNode(8, null, null));
//
//        System.out.println(sumWide(treeNode));
//        System.out.println("---------------");
//        System.out.println(sumDeep(treeNode));

//        char[][] grids =
//                {
//                        {'1', '1', '0', '0', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'0', '0', '1', '0', '0'},
//                        {'0', '0', '0', '1', '1'}
//                };
//
//        System.out.println(numIslands(grids));

//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    private static int numIslands(char[][] grids) {
        int count = 0;

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == '1') {
                    count++;
                    callBFS(grids, i, j);
                }
            }
        }
        return count;
    }

    private static void callBFS(char[][] grids, int i, int j) {
        if (i < 0 || i >= grids.length || j < 0 || j >= grids[i].length || grids[i][j] == '0') {
            return;
        }
        grids[i][j] = '0';

        callBFS(grids, i + 1, j);
        callBFS(grids, i - 1, j);
        callBFS(grids, i, j + 1);
        callBFS(grids, i, j - 1);
    }


//    private static boolean asdf(int[] numsA, int[] numsB) {
//        Iterator<Integer> iterator = null;
//        int[] numsForLoop;
//        if (numsA[0] > numsB[0]) {
//            iterator = Arrays.stream(numsA).iterator();
//            numsForLoop = numsB;
//        } else {
//            iterator = Arrays.stream(numsB).iterator();
//            numsForLoop = numsA;
//        }
//
//        for (int j : numsForLoop) {
//            if (iterator.hasNext()) {
//                int current = iterator.next();
//                if (current == j) {
//                    return true;
//                } else if (current > j) {
//                    continue;
//                } else {
//                    current = iterator.next();
//                }
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }

    public static boolean isBalanced(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        boolean result;

        int countLeft = 0;
        int countRight = 0;
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.remove(0);

            if (node.right != null) {
                countRight++;
                treeNodes.add(node.right);
            }
            if (node.left != null) {
                countLeft++;
                treeNodes.add(node.left);
            }
        }
        if (countLeft > countRight) {
            result = countLeft - countRight == 1;
        } else {
            result = countRight - countLeft == 1 || countRight - countLeft == 0;
        }
        return result;
    }

    public static int sumRecursive(TreeNode root) {
        int sum = root.val;
        if (root.left != null) {
            System.out.println("current left is " + root.left.val);
            sum += sumRecursive(root.left);
        }
        if (root.right != null) {
            System.out.println("current right is " + root.right.val);
            sum += sumRecursive(root.right);
        }
        return sum;
    }

    public static int sumDeep(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        int sum = 0;
        while (!stack.empty()) {
            TreeNode node = stack.pop();

            System.out.println(node.val);
            sum += node.val;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }

    public static int sumWide(TreeNode root) {
        System.out.println(root);
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        int sum = 0;
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.remove(0);
            sum += node.val;

            System.out.println(node.val);
            if (node.right != null) {
                treeNodes.add(node.right);
            }
            if (node.left != null) {
                treeNodes.add(node.left);
            }
        }
        return sum;
    }

//    public static int[] twoSum(int[] numbers, int target) {
//        int aPointer = 0;
//        int bPointer = numbers.length - 1;
//
//        while (aPointer <= bPointer) {
//            int sum = numbers[aPointer] + numbers[bPointer];
//            if (sum > target) {
//                bPointer -= 1;
//            } else if (sum < target) {
//                aPointer += 1;
//            } else {
//                return new int[] {aPointer + 1, bPointer + 1};
//            }
//        }
////        return new int[] {aPointer + 1, bPointer + 1};
//        List list = new ArrayList(); // 1
//        list.add("foo"); // 2
//        Object o  = list.get(0); // 3
//        String foo = (String) o; // 4
//
//        list.add(0, 1); // 5
//        Object oo = list.get(0); // 6
//        String bar = (String) oo; // 7
//    }

}

//    ID Name Age Salary
//
//1 John 30 1000
//
//        2 Jane 30 900
//
//        3 Jim 32 1000
//
//        4 James 30 1000
//
//        5 Julia 32 1500
//
//
//
//
//        ID Name Age Salary
//
//        1 John 30 1000
//
//        4 James 30 1000
//
//        5 Julia 32 1500
//
//        select e1.*
//        from employees e1
//        left join employees e2 on e2.salary > e1.salary and e2.age = e1.age
//        where e2.id is null;
//
//        select e1.*
//        from employees e1
//        where not exists (select * from employees e2 where e1.salary < e2.salary and e1.age = e2.age);


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    @Override
//    public int compareTo(TreeNode o) {
//        return 0;
//    }
}

