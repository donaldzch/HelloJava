package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_3 {
    /**
     * Given two strings, write a method to decide if one is permutation of the order.
     */
    private static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] mappings = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            mappings[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if(--mappings[s2.charAt(i)] < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "lleoh";

        if (isPermutation(s1, s2)) {
            System.out.print(s1 + " and " + s2 + " are permutation");
        } else {
            System.out.print(s1 + " and " + s2 + " are not permutation");
        }
    }
}
