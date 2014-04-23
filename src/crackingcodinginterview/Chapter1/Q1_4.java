package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_4 {
    /**
     * Write a method to replace all spaces in a string with '%20'. You may assume that the
     * string has sufficient space at the end of the string to hold additional characters,
     * and that you are given the "true" length of the string. (Note: if implementing in Java,
     * please use a character array so that you can perform this operation in place.)
     */
    private static void replaceSpaces(char[] chars, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        int newLength = length + spaceCount * 2;
        chars[newLength] = '\0';
        for (int j = length - 1; j >= 0; j--) {
            if (chars[j] == ' ') {
                chars[newLength - 1] = '0';
                chars[newLength - 2] = '2';
                chars[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                chars[newLength - 1] = chars[j];
                newLength -= 1;
            }
        }
    }

    public static void main(String[] args) {
        String hello = "hello world, joke!! ";
        char[] newChars = new char[256];
        for(int i= 0; i < hello.length(); i++)
            newChars[i] = hello.toCharArray()[i];
        replaceSpaces(newChars, hello.length());
        System.out.print(new String(newChars));
    }
}
