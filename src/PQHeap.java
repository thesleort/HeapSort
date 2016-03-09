
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Created by Troels Blicher Petersen on 09-Mar-16.
 */
public class PQHeap implements EQ {

    private static ArrayList<Element> A;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public PQHeap(int maxElms) {
        A = new ArrayList<>(maxElms);
    }

    public void HeapSort(ArrayList<Element> A) {
        BuildMaxHeap(A);
        for(int i = n; i > 1; i--) {
            Exchange(0,i);
            n--;
            MaxHeapify(A,0);
        }
    }

    private void BuildMaxHeap(ArrayList<Element> A) {
        n = A.size()-1;
        for(int i = (A.size())/2; i > 0; i--) {
            MaxHeapify(A,i);
        }
    }

    private void MaxHeapify(ArrayList<Element> A, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && A.get(left).key > A.get(i).key) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= n && A.get(right).key > A.get(largest).key) {
            largest = right;
        }
        if (largest != i) {
            Exchange(i, largest);
            MaxHeapify(A, largest);
        }
    }

    private void Exchange(int key, int key1) {
        Element temp = A.get(key);
        A.set(key,A.get(key1));
        A.set(key1, temp);
        System.out.println("\n\nExchanging " + A.get(key).key + " with " + A.get(key1).key);
        for(int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i).key + " ");
        }
    }

    public int HeapExtractMax(ArrayList<Element> A) throws Exception {
        if (n < 0) {
            throw HeapUnderFlowException();
        }
        int max = A.get(0).key;
        A.set(0, A.get(A.size() - 1));
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
        A.add(e);
    }

    public ArrayList<Element> getHeap() {
        return A;
    }
}
