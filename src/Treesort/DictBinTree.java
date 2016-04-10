package Treesort;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by mark- on 30-Mar-16.
 */
public class DictBinTree implements Dict {

    Knot Tree = new Knot(0);
// TREE-INSERT(T,z)
// y = NIL
// x = T.root
// while x != NIL
//    y = x
//    if z.key < x.key
//        x = x.left
//    else x = x.right
// z.p = y
// if y == NIL
//  T.root = z // tree T was empty
//  elseif z.key < y.key
//  y.left = z
//   else y.right = z


    @Override
    public void insert(int k) {
        Knot z = new Knot(k);
        Knot y = new Knot(k);
        Knot x = Tree;
        while (x !=  null) {
            //System.out.println("entering while loop");
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




    //    ITERATIVE-TREE-SEARCH.x; k/
//    while x ¤ NIL and k ¤ x:key
//      if k < x:key
//          x = x:left
//      else x = x:right
//          return x
    @Override
    public boolean search(int k) {
        Knot x = Tree;
        while (x != null && k != x.key) {
            if (k == x.key) {
                return true;
            } else if (k < x.key) {
                x = x.leftchild;
            } else {
                x = x.rightchild;
            }

        }
        return false;
    }


    //    INORDER-TREE-WALK.x/
//     if x ¤ NIL
//    2 INORDER-TREE-WALK.x: left/
//            3 print x:key
//    4 INORDER-TREE-WALK.x:right/

    @Override
    public int[] orderedTraversal() {

        ArrayList<Integer> order2 = new ArrayList();
        order2 = recursivetranversal(Tree, order2);
        int[] order = new int[order2.size()];
        for (int i = 0; i < order2.size(); i++) {
            order[i] = order2.get(i);
            //System.out.println("adding " + order2.get(i) + " to return list");
        }
        return order;
    }


    public ArrayList recursivetranversal(Knot knot, ArrayList order) {
        if (knot != null) {
            order = recursivetranversal(knot.leftchild, order);
            //System.out.println(knot.key);
            order.add(knot.key);
            order = recursivetranversal(knot.rightchild, order);

        }
        return order;

    }
//    @Override
//    public int[] orderedTraversal() {
//                            }
//
//    }


}



