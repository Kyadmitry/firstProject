package problem_231;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static boolean isPowerOfTwo2(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
