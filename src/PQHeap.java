
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by Mark on 05-Mar-16.
 */
public class PQHeap implements EQ {
    //private static Element[] A;
    private static ArrayList<Element> A;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public PQHeap(int maxElms) {
        A = new ArrayList<>(maxElms);
    }

    private void HeapBuild(ArrayList<Element> A) {
        n = A.size() - 1;
        IntStream.range(A.size(), 1).forEach(i -> {
            MinHeapify(A, i);

        });
    }

    private void MinHeapify(ArrayList<Element> A, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && A.get(left).key > A.get(i).key) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= n && A.get(right).key > A.get(largest).key)
            largest = right;
        if (largest != i) {
            Exchange(i, largest);
            MinHeapify(A, largest);
        }
    }

    private void Exchange(int i, int largest) {
        Element temp = A.get(i);
        A.set(i, A.get(largest));
        A.set(largest, temp);
    }


    public int HeapMin(ArrayList<Element> A) {
        return A.get(1).key;
    }

    public void Sort() {
        HeapBuild(A);
        //    IntStream.range(A.length, 0).forEach(i -> {
        for (int m = A.size() - 1; m > 0; m--) {
            Exchange(0, m);
            n--;
            MinHeapify(A, 0);

        }
    }

    @Override
    public Element extractMin() {
        return A.get(0);
    }

    /**
     * Inserts an element in the array/heap.
     *
     * @param e Element is an object.
     */
    @Override
    public void insert(Element e) {
        n++;
        A.add(e);
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

    private int HeapExtractMin(ArrayList<Element> A) {
        if (A.size() < 0) {
            int min = HeapMin(A);
            A.set(0, A.get(A.size()));
            //A.size() = A.size -1;
            MinHeapify(A, 1);
            return min;
        }
        return 0;
    }
    public ArrayList<Element> getHeap() {
        return A;
    }
    private void heapunderflowException() {
    }
}
