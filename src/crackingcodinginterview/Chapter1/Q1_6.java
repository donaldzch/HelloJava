package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_6 {
    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is 4
     * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
     */
    private static void rotateMatrix(int[][] matrix, int n) {
        int first, last;
        for (int i = 0; i < n/2; i++) {
            first = i;
            last = n - 1 - first;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int top = matrix[first][j];
                matrix[first][j] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateMatrix(matrix, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print("\n");
        }
    }
}
