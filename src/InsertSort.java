/**
 * Created by DonaldZhu on 4/16/14.
 */
public class InsertSort {

    private void sort(int[] data) {
        int t, j;
        for (int i = 0; i < data.length; i++) {
            t = data[i];
            for (j = i; j > 0 && data[j-1] > t; j--) {
                data[j] = data[j-1];
            }
            data[j] = t;
        }
    }

    public static void main(String[] args) {
        System.out.print("Insert Sort\n");
        int[] data = {1, 4, 5, 3, 6, 7};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(data);
        for (int s : data) {
            System.out.print(s + " | ");
        }
    }
}
