package Treesort;

import java.util.ArrayList;

/**
 * Created by Troels Blicher Petersen <troels@newtec.dk>    <trpet15>
 * & Mark jervelund          <Mark@jervelund.com>  <Mjerv15> on 30-Mar-16.
 */
public class DictBinTree implements Dict {

    Knot Tree = null;
    int size = 0;
    int position = 0;

    /**
     * Inserts an integer that acts as the key. It then
     * moves down the tree starting from the root until
     * it reaches a "child" that is null (no child is
     * actually present).
     * Afterwards it has to update the parent, so that
     * the parent knows whether the new node/knot is the
     * left child or the right child.
     *
     * @param k is the key for the node/knot. It is used
     *          in the comparison when trailing down the
     *          tree.
     */
    @Override
    public void insert(int k) {
        Knot z = new Knot(k);
        Knot y = null;
        Knot x = Tree;
        size++;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.leftchild;
            } else {
                x = x.rightchild;
            }
        }
        z.parent = y;
        if (y == null) {
            Tree = z;
        } else if (z.key < y.key) {
            y.leftchild = z;
        } else {
            y.rightchild = z;
        }
    }

    /**
     * Searches for a specified key and returns
     * true or false based on whether the key
     * exists or not.
     * It is important to note that this search
     * method is part of the interface where it
     * is defined that it must return a boolean.
     * In the textbook the search method returns
     * the pointer of a node/knot instead.
     *
     * @param k is the key to search for.
     * @return true or false based on whether
     *         the node/knot with the key exists
     *         in the tree.
     */
    @Override
    public boolean search(int k) {
        Knot x = Tree;
        while (x != null && k != x.key) {
            if (k < x.key) {
                x = x.leftchild;
            } else {
                x = x.rightchild;
            }
        }
        if (x != null && k == x.key) {
            return true;
        }
        return false;
    }

    /**
     * This method creates the building blocks
     * for the recursion. Afterwards it copies
     * all the information from the ArrayList
     * into an array. This is done, so that the
     * method can return an integer-array.
     *
     * @return A sorted array of integers from
     *         the tree.
     */
    @Override
    public int[] orderedTraversal() {
        int[] order = new int[size];
        order  = recursiveTraversal(Tree, order);
        return order;
    }

    /**
     * Recursive method that traverses down the
     * tree starting by the left children and
     * then "slowly working its way to the right.
     *              12
     *       5              18
     *   2       9      15      19
     *                13  17
     * Recursion through the tree above would
     * result in an array in the following order:
     * [2,5,9,12,13,15,17,18,19]
     *
     * @param knot The current knot.
     * @param order An ArrayList containing all
     *              the elements that has already
     *              been inserted in a sorted
     *              order.
     * @return Returns the final sorted order.
     */
    public int[] recursiveTraversal(Knot knot, int[] order) {
        if (knot != null) {
            order = recursiveTraversal(knot.leftchild, order);
            order[position] = knot.key;
            position++;
            order = recursiveTraversal(knot.rightchild, order);
        }
        return order;
    }
}



