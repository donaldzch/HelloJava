/**
 * Created by DonaldZhu on 4/17/14.
 */
public class SelectSort {
    private void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    swap(data, i, j);
                }
            }
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {7, 6, 5, 4, 3, 2, 1};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(data);
        System.out.print("data: ");
        for (int s : data) {
            System.out.print(s + " | ");
        }
    }
}
