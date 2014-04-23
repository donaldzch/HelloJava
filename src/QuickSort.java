/**
 * Created by DonaldZhu on 4/16/14.
 */
public class QuickSort {

    private void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = start;
        for (int i = start + 1; i < end + 1; i++) {
            if (data[i] < data[start]) {
                ++m;
                swap(data, m, i);
            }

        }
        swap(data, start, m);
        sort(data, start, m - 1);
        sort(data, m + 1, end);
    }

    private void sort1(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int t = data[start], i = start, j = end + 1;
        while(true) {
            do {
                i++;
            } while (i <= end && data[i] < t);
            do
                j--;
            while (data[j] > t);

            if ( i > j)
                break;
            swap(data, i, j);

        }
        swap(data, start, j);
        sort1(data, start, j-1);
        sort1(data, j+1, end);
    }

    private void sort2(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = end + 1;
        for (int i = end; i >= start; i--) {
            if (data[i] >= data[start]) {
                swap(data, --m, i);
            }
        }
        sort2(data, start, m - 1);
        sort2(data, m + 1, end);
    }

    private void sort3(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = end + 1, i = end + 1;
        do {
            while (data[--i] < data[start]);
            swap(data, --m, i);
        } while (i != start);
        sort3(data, start, m - 1);
        sort3(data, m + 1, end);
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        System.out.print("Quick Sort\n");
        int[] data = {7, 6, 5, 4, 3, 2, 1};
        int[] data1 = {7, 6, 5, 4, 3, 2, 1};
        int[] data2 = {7, 6, 5, 4, 3, 2, 1};
        int[] data3 = {7, 6, 5, 4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(data, 0, data.length - 1);
        quickSort.sort1(data1, 0, data1.length - 1);
        quickSort.sort2(data2, 0, data2.length - 1);
        quickSort.sort3(data3, 0, data3.length - 1);
        System.out.print("data: ");
        for (int s : data) {
            System.out.print(s + " | ");
        }
        System.out.print("\ndata1: ");
        for (int s : data1) {
            System.out.print(s + " | ");
        }
        System.out.print("\ndata2: ");
        for (int s : data2) {
            System.out.print(s + " | ");
        }
        System.out.print("\ndata3: ");
        for (int s : data3) {
            System.out.print(s + " | ");
        }
    }
}
