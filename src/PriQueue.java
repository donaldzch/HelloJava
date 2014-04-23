/**
 * Created by DonaldZhu on 4/17/14.
 */
public class PriQueue {
    private int size;
    private int n;
    private int[] data;

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public PriQueue(int size) {
        this.n = -1;
        this.size = size;
        this.data = new int[size];
    }

    public void insert(int value) {
        data[++n] = value;
        int i, p;
        for (i = n; data[p=(i-1)/2] >= data[i]; i = p)
            swap(i, p);
    }

    public int extractMin() {
        int returnValue = data[0];
        data[0] = data[n--];
        int i, c;
        for (i=0; (c=i*2+1) <= n;i=c) {
            if ( c + 1 <= n && data[c+1] < data[c])
                c++;
            if (data[i] <= data[c])
                break;
            swap(i, c);
        }
        return returnValue;
    }
}
