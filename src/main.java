import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Mark jervelund <Mark@jervelund.com> on 05-Mar-16.
 */
public class main {
    public static void main(String[] args) {
        PQHeap pqHeap = new PQHeap(20);
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNext()) {
            pqHeap.insert(new Element(i, sc.nextInt()));
            i++;

        }
        pqHeap.Sort();

    }
}
