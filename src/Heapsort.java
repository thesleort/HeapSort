import java.util.Scanner;

/**
 * Created by Mark jervelund          <Mark@jervelund.com>  <Mjerv15>
 * & Troels Blicher Petersen <troels@newtec.dk>    <trpet15>
 */
public class Heapsort {
    public static void main(String[] args) {

        /**
         * Creates a new heap.
         */
        PQHeap pqHeap = new PQHeap(0);

        /**
         * scans incoming data.
         */
        Scanner sc = new Scanner(System.in);

        /**
         * While loop inserts elements in the heap from the scanner.
         */
        if (sc != null) {
            while (sc.hasNext()) {
                int num = sc.nextInt();
                pqHeap.insert(new Element(num, null));
            }
        }

        /**
         * Calls the function to sort the Heaptree.
         */
        pqHeap.Sort();

        while (true) {
            try {
                int key = pqHeap.extractMin().key;
                System.out.print(key + " ");
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }
}
