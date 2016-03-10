import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Mark jervelund <Mark@jervelund.com>
 * & Troels Blicher Petersen <troels@newtec.dk>
 */
public class Heapsort {
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
                pqHeap.insert(new Element(num, null));
            }
        }

        /**
         * While loop shows unsorted array:
         */
        for (int j = 0; j < pqHeap.getHeap().length; j++) {
            System.out.println(pqHeap.getHeap()[j].key);
        }
        pqHeap.Sort();
        System.out.println("------------------------Sort----------------------------");
        for(int e = 0;e < pqHeap.getHeap().length; e++) {
            System.out.print(pqHeap.getHeap()[e].key+" ");
        }
        System.out.println();
        /**
         * While loop shows sorted array:
         */
        System.out.println("------------------------Extract------------------------");
        while(true) {
            try {
                int key = pqHeap.extractMin().key;
                System.out.print(key + " ");
//                if (key == 0) {
//                    break;
//                }
            }catch (ArrayIndexOutOfBoundsException e){
                break;
            }


        }
        System.out.println();
        System.out.println();
        System.out.println("length "+pqHeap.getHeap().length);

    }
}
