
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

    /**
     * The method that starts the sorting. It makes use of
     * several other methods, which then again makes use
     * of even more methods.
     *
     * @param A An array holding the elements of the heap.
     */
    public void HeapSort(Element[] A) {
        BuildMaxHeap(A);
        for (int i = n; i >= 1; i--) {
            Exchange(0, i);
            n--;
            MaxHeapify(A, 0);
        }
    }

    /**
     * Builds a heap and assigns a global variable n to the
     * size of the heap.
     *
     * @param A An array holding the elements of the heap.
     */
    private void BuildMaxHeap(Element[] A) {
        n = A.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            MaxHeapify(A, i);
        }
    }

    /**
     * Makes a max heap.
     *
     * @param A An array holding the elements of the heap.
     * @param i An integer telling where to do "work" in the heap.
     */
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

    /**
     * Swaps two elements in the global element-array.
     * @param key Position of the first element.
     * @param key1 Position of the second element.
     */
    private void Exchange(int key, int key1) {
        Element temp = A[key];
        A[key] = A[key1];
        A[key1] = temp;
    }

    /**
     * Takes the maximum element out of the heap. When doing so
     * it afterwards returns this element.
     *
     * @param A An array holding the elements of the heap.
     * @return The maximum element of the heap.
     * @throws Exception if there is no elements to be extracted from
     * the array.
     *
     * -This should be reimplemented in the @Override methods instead.
     */
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

    /**
     * Inserts an element in array A.
     *
     * @param A An array holding the elements of the heap.
     * @param i Where to insert the new element.
     * @param key The element to be inserted.
     */
    private void HeapIncreaseKey(Element[] A, int i, Element key) {
        if (key.key < A[i].key) {
            System.out.println("New key is smaller than current key");
        } else {
            A[i] = new Element(key.key, A[i].data);
            while (i > 0 && A[i / 2].key < A[i].key) {
                Exchange(A[i].key, A[i / 2].key);
                i = A[i / 2].key;
            }
        }
    }

    public void MaxHeapInsert(Element[] A, Element key) {
        n++;
        //A.add(new Element(Integer.MIN_VALUE, null));
        HeapIncreaseKey(A, n, key);
    }

    private Exception HeapUnderFlowException() {
        System.out.println("n is smaller than 0");
        return null;
    }

    /**
     * Simple call to sort the heap from outside of this class.
     */
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
        A = new Element[A.length + 1];
        System.arraycopy(temp, 0, A, 0, temp.length);
        A[A.length - 1] = e;
    }

    /**
     * Method to return the heap.
     *
     * @return Retuns the heap for outside usage.
     *
     * CAUTION: This returns the current heap and thus this
     * heap is only sorted if the method Sort() has been
     * called beforehand.
     */
    public Element[] getHeap() {
        return A;
    }
}
