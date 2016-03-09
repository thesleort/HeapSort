import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

/**
 * Created by Mark jervelund <Mark@jervelund.com>
 * & Troels Blicher Petersen <troels@newtec.dk>
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
                int num = sc.nextInt();
                pqHeap.insert(new Element(i, num));
                i++;
            }
        }
        /**
         * While loop shows unsorted array:
         */

        for (int j = 0; j < pqHeap.getHeap().size(); j++) {
            System.out.println(pqHeap.getHeap().get(j).key + " " + pqHeap.getHeap().get(j).data);
        }
        pqHeap.Sort();
        System.out.println("----------------------------");
        /**
         * While loop shows sorted array:
         */
        for (Element j : pqHeap.getHeap()) {
            System.out.println(j.key + " " + j.data);
        }
    }
}
