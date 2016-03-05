
import java.util.stream.IntStream;

/**
 * Created by Mark on 05-Mar-16.
 */
public class PQHeap implements EQ {
    private static Element[] A;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public PQHeap(int maxElms) {
        this.A = new Element[maxElms];
    }


    private void HeapBuild(Element A[]) {
        n = A.length - 1;
        IntStream.range(A.length, 1).forEach(i -> {
            MinHeapify(A, i);

        });
    }

    private void MinHeapify(Element[] A, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && A[left].key > A[i].key) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= n && A[right].key > A[largest].key)
            largest = right;
        if (largest != i) {
            Exchange(i, largest);
            MinHeapify(A, largest);
        }
    }

    private void Exchange(int i, int largest) {
        Element temp = A[i];
        A[i] = A[largest];
        A[largest] = temp;
    }


    public int HeapMin(Element A[]) {
        return A[1].key;
    }

    public void Sort() {
        HeapBuild(A);
        IntStream.range(A.length, 0).forEach(i -> {
            Exchange(0, i);
            n--;
            MinHeapify(A, 0);

        });

    }

    @Override
    public Element[] extractMin() {
        return A;
    }

    @Override
    public void insert(Element e) {
        Element[] temp = new Element[A.length+1];
        temp[temp.length-1] = e;
        A = temp;
    }

}
