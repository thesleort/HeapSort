import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Mark jervelund <Mark@jervelund.com> on 05-Mar-16.
 */
public class main {
    public static void main(String[] args) {
        PQHeap pqHeap = new PQHeap(20);
        File file = new File("Testnumbers.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (sc.hasNext()) {
            pqHeap.insert(new Element(i, sc.nextInt()));
            i++;

        }
        pqHeap.Sort();
        System.out.print(pqHeap.extractMin());

    }
}
