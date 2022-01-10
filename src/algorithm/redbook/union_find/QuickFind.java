package algorithm.redbook.union_find;

import algorithm.redbook.util.StdInUtil;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {

    private int count;
    private int[] id;

    public QuickFind(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return; //已连接的触点不进行冗余的连接操作
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        StdInUtil.setInput("tinyUF.txt");
        int count = StdIn.readInt();
        QuickFind quickFind = new QuickFind(count);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickFind.connected(p, q)) continue;
            quickFind.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickFind.count() + " components");
    }

}
