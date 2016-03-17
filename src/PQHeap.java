
/**
 *
 * Created by Mark jervelund          <Mark@jervelund.com>  <Mjerv15>
 *          & Troels Blicher Petersen <troels@newtec.dk>    <trpet15> on 09-Mar-16.
 */
public class PQHeap implements EQ {

    private static Element[] A;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    /**
     * Creates a heap of without any elements.
     *
     * @param maxElms The size of the heap.
     */
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
        BuildMinHeap(A);
        for (int i = n; i >= 1; i--) {
            Exchange(0, i);
            n--;
            MinHeapify(A, 0);
        }
    }

    /**
     * Builds a heap and assigns a global variable n to the
     * size of the heap.
     *
     * @param A An array holding the elements of the heap.
     */
    private void BuildMinHeap(Element[] A) {
        n = A.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            MinHeapify(A, i);
        }
    }

    /**
     * Makes a max heap.
     *
     * @param A An array holding the elements of the heap.
     * @param i An integer telling where to do "work" in the heap.
     */
    private void MinHeapify(Element[] A, int i) {
        left = 2 * i;
        right = (2 * i) + 1;
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
            MinHeapify(A, largest);
        }
    }

    /**
     * Swaps two elements in the global element-array.
     *
     * @param key  Position of the first element.
     * @param key1 Position of the second element.
     */
    private void Exchange(int key, int key1) {
        Element temp = A[key];
        A[key] = A[key1];
        A[key1] = temp;
    }

    /**
     * Inserts an element in array A.
     *
     * @param A   An array holding the elements of the heap.
     * @param i   Where to insert the new element.
     * @param key The element to be inserted.
     */
    private void HeapIncreaseKey(Element[] A, int i, Element key) {
        if (key.key >= A[i].key) {
            A[i] = new Element(key.key, A[i].data);
            while (i > 0 && A[i / 2].key > A[i].key) {
                Exchange(i, i / 2);
                i = i / 2;
        }
        }
    }

    /**
     * Simple call to sort the heap from outside of this class.
     */
    public void Sort() {
        HeapSort(A);
    }

    /**
     * Takes the maximum element out of the heap. When doing so
     * it afterwards returns this element.
     *
     * @return The maximum element of the heap.
     * @throws Exception if there is no elements to be extracted from
     *                   the array.
     */
    @Override
    public Element extractMin() {
        n = A.length - 1;
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Element max = A[0];
        A[0] = A[n];
        MinHeapify(A, 0);
        Element[] temp = A.clone();
        A = new Element[A.length - 1];
        System.arraycopy(temp, 1, A, 0, temp.length - 1);
        return max;
    }

    /**
     * Inserts an element in the heap and increases the heap size.
     * It uses HeapIncreaseKey to insert the element at an allowed
     * position.
     *
     * @param e The element to be inserted.
     */
    @Override
    public void insert(Element e) {
        n++;
        Element[] temp = A.clone();
        A = new Element[A.length + 1];
        System.arraycopy(temp, 0, A, 0, temp.length);
        A[A.length - 1] = e;
        HeapIncreaseKey(A, n - 1, e);
    }

    /**
     * Method to return the heap.
     *
     * @return Retuns the heap for outside usage.
     * <p/>
     * CAUTION: This returns the current heap and thus this
     * heap is only sorted if the method Sort() has been
     * called beforehand.
     */
    public Element[] getHeap() {
        return A;
    }
}
