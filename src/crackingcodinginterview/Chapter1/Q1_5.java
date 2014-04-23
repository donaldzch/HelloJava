package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_5 {
    /**
     * Implement a method to perform basic string compression using the counts of
     * repeated characters. For example, the string aabcccccaaa would become
     * a2b1c5a3. If the "compressed" string would not become smaller than the original
     * string, your method should return the original string.
     */
    private static int getCompressionCount(String var) {
        int count = 0, i, j;
        for (i = 0; i < var.length(); i++) {
            int strCount = 1;
            char character = var.charAt(i);
            for (j = i + 1; j < var.length(); j++) {
                if (character == var.charAt(j)) {
                    strCount++;
                } else {
                    break;
                }
            }
            i = j - 1;
            count += 1 + String.valueOf(strCount).length();
        }
        return count;
    }

    private static String getCompressionString(String original) {
        if (original == null || original.isEmpty()) {
            return original;
        }

        int compressionCount = getCompressionCount(original);
        if (compressionCount > original.length()) {
            return original;
        }
        char[] compressed = new char[compressionCount+1];

        int count = 0, i, j;
        for (i = 0; i < original.length(); i++) {
            int strCount = 1;
            char character = original.charAt(i);
            for (j = i + 1; j < original.length(); j++) {
                if (character == original.charAt(j)) {
                    strCount++;
                } else {
                    break;
                }
            }
            i = j - 1;
            compressed[count++] = character;
            for(int k = 0; k < String.valueOf(strCount).length(); k++) {
                compressed[count++] = String.valueOf(strCount).charAt(k);
            }
        }
        compressed[compressionCount] = '\0';

        return String.valueOf(compressed);
    }

    public static void main(String[] args) {
        System.out.print(getCompressionString("aabcccccaaa"));
    }
}
