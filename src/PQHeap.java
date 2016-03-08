
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
        A = new Element[maxElms];
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
    //    IntStream.range(A.length, 0).forEach(i -> {
            for(int m = A.length-1; m > 0; m--){
            Exchange(0, m);
            n--;
            MinHeapify(A, 0);

        }
    }

    @Override
    public Element[] extractMin() {
        return A;
    }

    /**
     * Inserts an element in the array/heap.
     * @param e Element is an object.
     */
    @Override
    public void insert(Element e) {
        n++;
        Element[] temp = A.clone();
        A = new Element[A.length+1];
        System.arraycopy(temp,0,A,0,temp.length);
        A[A.length-1] = e;
//        A.clone();
//        A = new Element[temp.length];
//        for(int i = 0; i < temp.length; i++){
//            A[i] = temp[i];
//        }
//
//        System.out.println("-----------------------------"+A[0].data);

    }
    public void insertnSort(Element e) {
        insert(e);
        Sort();
    }

}
