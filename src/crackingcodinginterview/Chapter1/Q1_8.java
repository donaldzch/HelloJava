package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_8 {
    /**
     * Assume you have a method isSubstring which checks if one word is a substring
     * of another. Given two strings, s1 and s2. write code to check if s2 is a rotation of s2
     * using only one call to isSubstring (e.g., "waterbottle" is a rotation of "erbo-
     * tlewat")
     */
    private static boolean isRotationString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String s3 = s1 + s1;
        if (s3.contains(s2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbotelewat";

        if (isRotationString(s1, s2)) {
            System.out.print(s1 + " is a rotation of " + s2);
        } else {
            System.out.print(s1 + " is not a rotation of " + s2);
        }
    }
}
