package Treesort;

/**
 * Created by mark- on 30-Mar-16.
 */
public class TreeSort {

// TREE-INSERT.T; ´/
// y = NIL
// x = T:root
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
private void insert(){
    int y = 1; //should be nil
    int x = 2; //should be t.root
    while (x != y){
        y = x;

    }

}
//TREE-SEARCH(x, k)
//    if x == NIL or k == x.key
//        return x
//    if k < x.key
//        return TREE-SEARCH.x(left, k)
//    else return TREE-SEARCH(x.right, k)
private void search(){
    System.out.println("test");
}

//    ITERATIVE-TREE-SEARCH.x; k/
//            1 while x ¤ NIL and k ¤ x:key
//    2 if k < x:key
//    3 x D x:left
//    4 else x D x:right
//    5 return x

//    INORDER-TREE-WALK.x/
//            1 if x ¤ NIL
//    2 INORDER-TREE-WALK.x: left/
//            3 print x:key
//    4 INORDER-TREE-WALK.x:right/
    private void walk(){

    }
}



