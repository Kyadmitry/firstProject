public class PalindromeNumber {


    public static void main(String[] args) {
        System.out.println(isPalindrome2(20));
    }

    public static boolean isPalindrome2(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reversedNum = 0;
        while (x > reversedNum) {
            int current = x % 10;
            x /= 10;
            reversedNum = reversedNum * 10 + current;
        }

        return x == reversedNum || x == reversedNum / 10;
    }

}
