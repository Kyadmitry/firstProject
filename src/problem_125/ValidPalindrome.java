package problem_125;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("123qwe321"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder fixedString = new StringBuilder();
        char[] sourceCharArray = s.toCharArray();

        for (char ch: sourceCharArray) {
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                fixedString.append(ch);
            }
        }

        fixedString = new StringBuilder(fixedString.toString().toLowerCase());

        int leftPointer = 0;
        int rightPointer = fixedString.length() - 1;

        while (leftPointer <= rightPointer) {
            if (fixedString.charAt(leftPointer) != fixedString.charAt(rightPointer)) {
                return false;
            }
            leftPointer += 1;
            rightPointer -= 1;
        }
        return true;
    }
}
