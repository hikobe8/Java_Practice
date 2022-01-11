package algorithm.redbook.interview.union_find;

import edu.princeton.cs.algs4.StdOut;

/**
 * Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that find(i)
 * returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 * <p>
 * For example, if one of the connected components is {1,2,6,9},
 * then the find() method should return 9 for each of the four elements in the connected components.
 */
public class SuccessorWithDelete {

    private int count;
    private int[] id;

    public SuccessorWithDelete(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
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
        if (pRoot > qRoot) {
            id[qRoot] = pRoot;
        } else {
            id[pRoot] = qRoot;
        }
        count--;
    }

    public void remove(int x) {
        union(x, x + 1);
    }

    public int getSuccessor(int x) {
        return root(x);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        SuccessorWithDelete s = new SuccessorWithDelete(10);
        s.remove(6);
        s.remove(5);
        s.remove(3);
        StdOut.println("the successor of 3 is " + s.getSuccessor(3));
        s.remove(4);
        StdOut.println("the successor of 3 is " + s.getSuccessor(3));
        s.remove(7);
        StdOut.println("the successor of 3 is " + s.getSuccessor(3));
        StdOut.println("the successor of 4 is " + s.getSuccessor(4));
        StdOut.println("the successor of 1 is " + s.getSuccessor(1));
    }

}
