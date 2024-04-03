package problem_567;

import java.util.Stack;

public class PermutationInString {

    public static void main(String args[]) {
        permutation("boat");
    }

    /*
     * A method exposed to client to calculate permutation of String in Java.
     */
    public static void permutation(String input){
        permutation("", input);
    }

    /*
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     */
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String availableCharsSpace = word.substring(0, i) + word.substring(i + 1);
                String currentPerm = perm + word.charAt(i);
                permutation(currentPerm, availableCharsSpace);
            }
        }
    }

    private static void permutation2(String perm, String word) {
        Stack<String> perms = new Stack<>();
        Stack<String> words = new Stack<>();

        perms.push(perm);
        words.push(word);

        while (!perms.isEmpty()) {
            perm = perms.pop();
            word = words.pop();

            if (word.isEmpty()) {
                System.err.println(perm);
            } else {
                for (int i = 0; i < word.length(); i++) {
                    String currentWord = word.substring(0, i) + word.substring(i + 1);
                    String currentPerm = perm + word.charAt(i);

                    perms.push(currentPerm);
                    words.push(currentWord);
                }
            }
        }
    }

}
