

public class HeapSort {
    public static void main(String[] args) {
        System.out.println("CR4P");
    }


    /*
    HEAPSORT.A/
    1 BUILD-MAX-HEAP.A/
    2 for i D A:length downto 2
    3 exchange AOE1 with AOEi
    4 A:heap-size D A:heap-size  1
    5 MAX-HEAPIFY.A; 1/
     */
    /*
    MAX-HEAP-INSERT.A; key/
    1 A:heap-size D A:heap-size C 1
    2 AOEA:heap-size D 1
    3 HEAP-INCREASE-KEY.A;A:heap-size; key/


     */

    /*
    HEAP-INCREASE-KEY.A; i; key/
    1 if key < AOEi
    2 error “new key is smaller than current key”
    3 AOEi D key
    4 while i > 1 and AOEPARENT.i / < AOEi
    5 exchange AOEi with AOEPARENT.i /
    6 i D PARENT.i /
     */

    /*
    HEAP-MAXIMUM.A/
    1 return AOE1
    */

    /*
    HEAP-EXTRACT-MAX.A/
1 if A:heap-size < 1
2 error “heap underflow”
3 max D AOE1
4 AOE1 D AOEA:heap-size
5 A:heap-size D A:heap-size  1
6 MAX-HEAPIFY.A; 1/
7 return max
     */


}