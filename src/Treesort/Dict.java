package Treesort;

/**
 * Created by mark- on 30-Mar-16.
 */
public interface Dict {
    public void insert(int k);
    public int[] orderedTraversal();
    public boolean search(int k);

    //    ITERATIVE-TREE-SEARCH.x; k/
//    while x ¤ NIL and k ¤ x:key
//      if k < x:key
//          x = x:left
//      else x = x:right
//          return x
    boolean search(Knot x, int k);
}
