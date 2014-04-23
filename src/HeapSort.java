/**
 * Created by DonaldZhu on 4/17/14.
 */
public class HeapSort {
    private int[] data;

    public HeapSort(int[] data) {
        this.data = data;
    }

    public int getRoot() {
        return this.data[0];
    }

    public int getValue(int i) {
        return this.data[i-1];
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public int getParent(int i) {
        return (i-1)/2;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void siftUp(int position) {
        int i, p;
        for (i = position; data[p=getParent(i)] < data[i]; i = p)
            swap(p, i);
    }

    private void siftDown0(int size) {
        int i = 0, c;
        while (true) {
            c = leftChild(i);
            if (c > size)
                break;
            if (c + 1 <= size && data[c+1] > data[c])
                c++;
            if (data[i] >= data[c])
                break;
            swap(i, c);
            i = c;
        }
    }

    private void siftDown(int size) {
        int i, c;
        for (i=0; (c=leftChild(i)) <= size; i=c) {
            if (c+1 <= size && data[c+1] > data[c])
                c++;
            if (data[i] >= data[c])
                break;
            swap(i, c);
        }
    }

    private void sort() {
        for (int i = 1; i < data.length; i++)
            siftUp(i);
        for (int i = data.length - 1; i > 0; i--) {
            swap(0, i);
            siftDown(i-1);
        }
    }

    public void getData() {
        sort();
        for (int s : data) {
            System.out.print(s + " | ");
        }
    }

    public static void main(String[] args) {
        int[] data = {0, 6, 5, 4, 3, 2, 1};
        HeapSort heapSort = new HeapSort(data);
        heapSort.getData();
    }
}
