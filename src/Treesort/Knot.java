package Treesort; /**
 * Created by trpet15 - Troels Blicher Petersen <troels@newtec.dk> on 3/4/16.
 */

/**
 * This object holds a key and an object.
 * The key is the one to be sorted and the
 * object may hold whatever data.
 */
public class Knot {
    public int key;
    public Knot leftchild;
    public Knot rightchild;
    public Knot parent;

    public Knot(int i) {
        this.key = i;
        this.leftchild = null;
        this.rightchild = null;
        this.parent =null;
    }
}


