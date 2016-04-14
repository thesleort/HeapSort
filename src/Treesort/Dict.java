package Treesort;

/**
 * Created by Troels Blicher Petersen <troels@newtec.dk>    <trpet15>
 *          & Mark jervelund          <Mark@jervelund.com>  <Mjerv15> on 30-Mar-16.
 */
public interface Dict {
    public void insert(int k);

    public int[] orderedTraversal();

    public boolean search(int k);
}
