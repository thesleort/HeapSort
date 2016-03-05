import javax.lang.model.element.*;
import javax.lang.model.element.Element;
import java.util.stream.IntStream;

/**
 * Created by Mark on 05-Mar-16.
 */
public class PQHeap implements EQ {
    public PQHeap(int maxElms){
            }
    private static int[] A;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    private void HeapBuild(int A[]) {
        n = A.length-1;
        IntStream.range(A.length, 1).forEach(i -> {
            MinHeapify(A, i);

        });
    }

    private void MinHeapify(int[] A, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && A[left] > A[i]){
            largest = left;
        }
        else{ largest = i;}
        if (right <= n && A[right] > A[largest])
            largest = right;
        if (largest != i){
            Exchange(i,largest);
            MinHeapify(A, largest);
        }
    }

    private void Exchange(int i, int largest) {
        int temp = A[i];
        A[i] = A[largest];
        A[largest] = temp;
    }


    private int HeapMin(int A[]) {
        return A[1];
    }
    private void Sort(int[] A) {
        HeapBuild(A);
        IntStream.range(A.length, 0).forEach(i -> {
            Exchange(A[0],A[i]);
            n--;
            MinHeapify(A,0);

        });

    }

    @Override
    public javax.lang.model.element.Element extractMin() {
        return null;
    }

    @Override
    public void insert(Element e) {

    }
}
