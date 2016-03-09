
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Created by Troels Blicher Petersen on 09-Mar-16.
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

    public void HeapSort(Element[] A) {
        BuildMaxHeap(A);
        for(int i = n; i >= 1; i--) {
            Exchange(0,i);
            n--;
            MaxHeapify(A,0);
        }
    }

    private void BuildMaxHeap(Element[] A) {
        n = A.length-1;
        for(int i = n/2; i >= 0; i--) {
            MaxHeapify(A,i);
        }
    }

    private void MaxHeapify(Element[] A, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && A[left].key > A[i].key) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= n && A[right].key > A[largest].key) {
            largest = right;
        }
        if (largest != i) {
            Exchange(i, largest);
            MaxHeapify(A, largest);
        }
    }

    private void Exchange(int key, int key1) {
        Element temp = A[key];
        A[key] = A[key1];
        A[key1] = temp;

        System.out.println("\n\nExchanging " + A[key].key + " with " + A[key1].key);
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i].key + " ");
        }
    }

    public int HeapExtractMax(Element[] A) throws Exception {
        if (n < 0) {
            throw HeapUnderFlowException();
        }
        int max = A[0].key;
        A[0] = A[n];
        n--;
        MaxHeapify(A, 0);
        return max;
    }

    private void HeapIncreaseKey(ArrayList<Element> A, int i, Element key) {
        if (key.key < A.get(i).key) {
            System.out.println("New key is smaller than current key");
        } else {
            A.set(i, new Element(key.key, A.get(i).data));
            while (i > 0 && A.get(i / 2).key < A.get(i).key) {
                Exchange(A.get(i).key, A.get(i / 2).key);
                i = A.get(i / 2).key;
            }
        }
    }

    public void MaxHeapInsert(ArrayList<Element> A, Element key) {
        n++;
        A.add(new Element(Integer.MIN_VALUE, null));
        HeapIncreaseKey(A, n, key);
    }

    private Exception HeapUnderFlowException() {
        System.out.println("n is smaller than 0");
        return null;
    }

    public void Sort() {
        HeapSort(A);
    }

    @Override
    public Element extractMin() {
        return null;
    }

    @Override
    public void insert(Element e) {
        n++;
        Element[] temp = A.clone();
        A = new Element[A.length+1];
        System.arraycopy(temp,0,A,0,temp.length);
        A[A.length-1] = e;
    }

    public Element[] getHeap() {
        return A;
    }
}
