package Heapsort;

import java.util.ArrayList;

/**
 *
 * Created by Mark jervelund          <Mark@jervelund.com>  <Mjerv15>
 *          & Troels Blicher Petersen <troels@newtec.dk>    <trpet15> on 09-Mar-16.
 */
public class PQHeap implements EQ {

    private static ArrayList<Element> A;
    private static int n;
    private static int left;
    private static int right;
    private static int smallest;

    /**
     * Creates a heap of without any elements.
     */
    public PQHeap() {
        A = new ArrayList<>();
    }

    /**
     * The method that starts the sorting. It makes use of
     * several other methods, which then again makes use
     * of even more methods.
     *
     * @param A An array holding the elements of the heap.
     */
    public void HeapSort(ArrayList<Element> A) {
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
    private void BuildMinHeap(ArrayList<Element> A) {
        n = A.size() - 1;
        for (int i = n / 2; i >= 0; i--) {
            MinHeapify(A, i);
        }
    }

    /**
     * Makes a min heap.
     *
     * @param A An array holding the elements of the heap.
     * @param i An integer telling where to do "work" in the heap.
     */
    private void MinHeapify(ArrayList<Element> A, int i) {
        left = 2 * i;
        right = (2 * i) + 1;
        if (left <= n && A.get(left).key < A.get(i).key) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right <= n && A.get(right).key < A.get(smallest).key) {
            smallest = right;
        }
        if (smallest != i) {
            Exchange(i, smallest);
            MinHeapify(A, smallest);
        }
    }

    /**
     * Swaps two elements in the global element-array.
     *
     * @param key  Position of the first element.
     * @param key1 Position of the second element.
     */
    private void Exchange(int key, int key1) {
        Element temp = A.get(key);
        A.set(key,A.get(key1));
        A.set(key1,temp);
    }

    /**
     * Inserts an element in array A.
     *
     * @param A   An array holding the elements of the heap.
     * @param i   Where to insert the new element.
     * @param key The element to be inserted.
     */
    private void HeapIncreaseKey(ArrayList<Element> A, int i, Element key) {
        if (key.key >= A.get(i).key) {
            A.set(i,new Element(key.key, A.get(i).data));
            while (i > 0 && A.get(i / 2).key > A.get(i).key) {
                Exchange(i, i / 2);
                i = i / 2;
            }
        }
    }

    /**
     * Takes the minimum element out of the heap. When doing so
     * it afterwards returns this element.
     *
     * @return The minimum element of the heap.
     * @throws Exception if there is no elements to be extracted from
     *                   the array.
     */
    @Override
    public Element extractMin() {
        n = A.size() - 1;
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Element min = A.get(0);
        A.set(0,A.get(n));
        MinHeapify(A, 0);
        A.remove(n);
        return min;
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
        A.add(e);
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
    public ArrayList<Element> getHeap() {
        return A;
    }
}
