/**
 * Created by DonaldZhu on 4/17/14.
 */
public class SelectMaxK {
    private int select(int[] data, int start, int end, int k) {
        if (start == end) {
            return data[k-1];
        }
        int t = data[start], i = start, j = end + 1;
        while (true) {
            do {
                i++;
            } while (i <= end && data[i] < t);
            do {
                j--;
            } while (data[j] > t);
            if (i > j) {
                break;
            }
            swap(data, i, j);
        }
        swap(data, start, j);
        if (j<k) {
            return select(data, j+1, end, k);
        } else if (j > k) {
            return select(data, start, j-1, k);
        } else {
            return data[k-1];
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {1, -3, 7, 8, 4, 6, 5, 2, 9, 10};
        SelectMaxK selectMaxK = new SelectMaxK();
        System.out.print(selectMaxK.select(data, 0, data.length-1, 3));
    }
}
