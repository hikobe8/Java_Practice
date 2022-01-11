package algorithm.redbook.interview.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that find(i)
 * returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9},
 * then the find() method should return 9 for each of the four elements in the connected components.
 */
public class UnionFindWithSpecificCanonicalElement {

    private int count;
    private int[] id;

    public UnionFindWithSpecificCanonicalElement(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        if (pRoot > qRoot) {
            id[qRoot] = pRoot;
        } else {
            id[pRoot] = qRoot;
        }
        count --;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int count = StdIn.readInt();
        UnionFindWithSpecificCanonicalElement find = new UnionFindWithSpecificCanonicalElement(count);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (find.connected(p, q)) continue;
            find.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(find.count() + " components");
    }

}
