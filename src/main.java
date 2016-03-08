import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

/**
 *      Created by Mark jervelund <Mark@jervelund.com>
 *      & Troels Blicher Petersen <troels@newtec.dk>
 */
public class main {
    public static void main(String[] args) {
        PQHeap pqHeap = new PQHeap(0);
        File file = new File("testnumbers");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (sc != null) {
            while (sc.hasNext()) {
                pqHeap.insert(new Element(i, sc.nextInt()));
                i++;
            }
        }
        /**
         * While loop shows unsorted array:
         */
        pqHeap.Sort();
        for (Element j : pqHeap.extractMin()) {
            System.out.println(j.data);
        }
        System.out.println("----------------------------");
        /**
         * While loop shows sorted array:
         */
        int g = pqHeap.extractMin().length;
        for (Element j : pqHeap.extractMin()) {
            System.out.println(j.data);
        }
    }
}
