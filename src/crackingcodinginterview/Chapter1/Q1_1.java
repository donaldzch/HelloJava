package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_1 {
    /**
     * Implement an algorithm to determine if a string has all unique characters. What if
     * you cannot use additional data structures?
     */
    private static boolean hasUniqueCharacters(String variable) {
        if (variable == null || variable.isEmpty()) {
            return true;
        }
        //suppose only 256 characters are available
        boolean[] characters = new boolean[256];
        for (int i = 0; i < variable.length(); i++) {
            char character = variable.charAt(i);
            if (characters[character]) {
                return false;
            }
            characters[character] = true;
        }
        return true;
    }

    private static boolean hasUniqueCharacters1(String variable) {
        if (variable == null || variable.isEmpty()) {
            return true;
        }
        //suppose only a-z characters
        int characters = 0;
        for (int i = 0; i < variable.length(); i++) {
            int character = variable.charAt(i) - 'a';

            if ((characters & (1 << character)) != 0) {
                return false;
            }
            characters |= 1 << character;
        }

        return true;
    }

    private static boolean hasUniqueCharacters2(String variable) {
        if (variable == null || variable.isEmpty()) {
            return true;
        }
        //suppose only 256 characters
        int[] characters = new int[8];
        for (int i = 0; i < variable.length(); i++) {
            int position = variable.charAt(i) / 32;
            int offset = variable.charAt(i) % 32;

            if ((characters[position] & (1 << offset )) != 0) {
                return false;
            }
            characters[position] |= 1 << offset;
        }
        return true;
    }

    private static boolean hasUniqueCharacters3(String variable) {
        if (variable == null || variable.isEmpty()) {
            return true;
        }

        for (int i = 0; i < variable.length(); i++) {
            char character = variable.charAt(i);
            for (int j = i + 1; j < variable.length(); j++) {
                if (character == variable.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String hello = "helo";
        if (hasUniqueCharacters3(hello)) {
            System.out.print(hello + " has unique characters");
        } else {
            System.out.print(hello + " has not unique characters");
        }
    }
}
