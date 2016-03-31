package Treesort;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by mark- on 30-Mar-16.
 */
public class DictBinTree implements Dict {

    Knot Tree = new Knot(0);

    public int right(int k) {
        return (k * 2 + 1);
    }

    private int left(int k) {
        return (k * 2);
    }

    private int parent(int k) {
        return (k / 2);

    }
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
    public void insert(int z) {
        Knot k = null;
        k.key = z;
        Knot y = null;
        Knot x = Tree;
        while (x != null) {
            y = x;
            if (k.key < x.key) {
                x = x.leftchild;
            } else {
                x = x.leftchild;
            }
            k.parent = y;

            if (y == null) {
                Tree = k;
            } else if (k.key < y.key) {
                y.leftchild = k;
            } else {
                y.rightchild = k;
            }
        }
    }

    @Override
    public int[] orderedTraversal() {
        return new int[0];
    }

    @Override
    public boolean search(int k) {
        return false;
    }


    //    ITERATIVE-TREE-SEARCH.x; k/
//    while x ¤ NIL and k ¤ x:key
//      if k < x:key
//          x = x:left
//      else x = x:right
//          return x
        @Override
        public boolean search(Knot x, int k){
            while (x != null && k != x.key){
                if (k == x.key){return true;
            }else if (k < x.key){x = x.leftchild;}
                else {x = x.rightchild;}

        }
            return false;
        }





//    INORDER-TREE-WALK.x/
//     if x ¤ NIL
//    2 INORDER-TREE-WALK.x: left/
//            3 print x:key
//    4 INORDER-TREE-WALK.x:right/


//    @Override
//    public int[] orderedTraversal() {
//                            }
//
//    }


}



