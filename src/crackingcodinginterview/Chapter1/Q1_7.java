package crackingcodinginterview.Chapter1;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q1_7 {
    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
     * column are set to 0.
     */
    private static void zeroMatrix(int[][] matrix, int m, int n) {
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!columns[j]) {
                    if (matrix[i][j] == 0) {
                        columns[j] = true;
                        rows[i] = true;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 0, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 0},
                {16, 17, 18, 19, 20}
        };
        zeroMatrix(matrix, 4, 5);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + ",\t");
            }
            System.out.print("\n");
        }
    }
}
