/**
 * Created by DonaldZhu on 4/17/14.
 */
public class ShellSort {
    private void sort(int[] data) {
        int h;
        for (h = 1; h < data.length; h = 3*h + 1);
        while(true) {
            h /= 3;
            if (h < 1) {
                break;
            }
            for (int i = h + 1; i < data.length - 1; i++) {
                for (int j = i; j >=h; j-=h) {
                    if (data[j-h] < data[j])
                        break;
                    swap(data, j-h, j);
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
        System.out.print("Shell Sort\n");
        int[] data = {7, 6, 5, 4, 3, 2, 1};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(data);
        for (int s : data) {
            System.out.print(s + " | ");
        }
    }
}
