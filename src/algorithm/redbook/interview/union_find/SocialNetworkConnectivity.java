package algorithm.redbook.interview.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Social network connectivity.
 * Given a social network containing n members and a log file containing m timestamps at
 * which times pairs of members formed friendships, design an algorithm to determine the
 * earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be m*logn or better and use extra space proportional to nn.
 */
public class SocialNetworkConnectivity {

    private int count;
    private int[] relation;
    private int[] size;

    public SocialNetworkConnectivity(int count) {
        this.count = count;
        relation = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            relation[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p) {
        while (p != relation[p]) {
            relation[p] = relation[relation[p]];
            p = relation[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        return pRoot == qRoot;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (qRoot == pRoot) {
            return;
        }
        if (size[pRoot] > size[qRoot]) {
            relation[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            relation[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        count --;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int count = StdIn.readInt();
        SocialNetworkConnectivity socialNetworkConnectivity = new SocialNetworkConnectivity(count);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (socialNetworkConnectivity.connected(p, q)) continue;
            socialNetworkConnectivity.union(p, q);
            if (socialNetworkConnectivity.count() == 1){
                long timeStamp = StdIn.readLong();
                StdOut.println("the earliest time at which all members are connected = " + timeStamp);
                break;
            }
        }
    }

}
