import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Mark jervelund <Mark@jervelund.com>
 * & Troels Blicher Petersen <troels@newtec.dk>
 */
public class main {
    public static void main(String[] args) {
        PQHeap pqHeap = new PQHeap(0);
        Scanner sc = null;
        try {
            File file = new File("testnumbers");
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * While loop inserts elements in the heap.
         */
        if (sc != null) {
            while (sc.hasNext()) {
                int num = sc.nextInt();
                pqHeap.insert(new Element(num, num));
            }
        }

        /**
         * While loop shows unsorted array:
         */
        for (int j = 0; j < pqHeap.getHeap().length; j++) {
            System.out.println(pqHeap.getHeap()[j].key + " " + pqHeap.getHeap()[j].data);
        }
        pqHeap.Sort();
        System.out.println("\n----------------------------");
        /**
         * While loop shows sorted array:
         */
        for (Element j : pqHeap.getHeap()) {
            System.out.println(j.key + " " + j.data);
        }
    }
}
