/**
 * Created by DonaldZhu on 4/15/14.
 */
public class BinarySearch {

    private int search(int[] data, int start, int end, int t) {
        int l = start, r = end, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (data[m] > t) {
                r = m - 1;
            } else if (data[m] == t) {
                return m;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.print("Binary Search\n");
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        BinarySearch binarySearch = new BinarySearch();
        System.out.print(binarySearch.search(data, 0, data.length - 1, 3));
        System.out.print("\n");
        System.out.print(binarySearch.search(data, 0, data.length - 1, 1));

    }
}
