package Treesort;

import Heapsort.Element;

import java.util.Scanner;

/**
 * Created by Mark jervelund <Mark@jervelund.com> on 10-Apr-16.
 */
public class Treesort {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Running Tree sort");
        DictBinTree dt = new DictBinTree();
        /**
         * scans incoming data.
         */
        Scanner sc = new Scanner(System.in);

        /**
         * While loop inserts elements in the heap from the scanner.
         */


        if (sc != null) {
            dt.Tree.key = sc.nextInt();

            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                //System.out.println("inserting "+num);
                dt.insert(num);
            }
        }

        int [] list = dt.orderedTraversal();
        for (int i = 0; i < list.length ; i++) {
            System.out.print(list[i]+" ");

        }
    }
}
