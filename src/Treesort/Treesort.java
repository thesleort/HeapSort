package Treesort;

import java.util.Scanner;

/**
 * Created by Troels Blicher Petersen <troels@newtec.dk>    <trpet15>
 *          & Mark jervelund          <Mark@jervelund.com>  <Mjerv15> on 30-Mar-16.
 */
public class Treesort {
    public static void main(String[] args) {
        System.out.println("Running Tree sort");
        DictBinTree dt = new DictBinTree();

        /**
         * Scans for incoming data.
         */
        Scanner sc = new Scanner(System.in);

        /**
         * While loop inserts elements in the tree from the scanner.
         */
        if (sc != null) {
            dt.Tree.key = sc.nextInt();
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                dt.insert(num);
            }
        }
        int [] list = dt.orderedTraversal();
        for (int i = 0; i < list.length ; i++) System.out.println(list[i]);
    }
}
