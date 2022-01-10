package algorithm.redbook.union_find;

import algorithm.redbook.util.StdInUtil;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 加权的QuickUnion, 使用路径压缩优化查找
 */
public class WeightedQuickUnionWithPathCompress {

    private int count;
    private int[] id;
    private int[] size;

    public WeightedQuickUnionWithPathCompress(int count) {
        this.count = count;
        id = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        //递归寻找根节点
        while (id[p] != p) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return; //已连接的触点不进行冗余的连接操作
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
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
        StdInUtil.setInput("largeUF.txt");
        int count = StdIn.readInt();
        WeightedQuickUnionWithPathCompress quickFind = new WeightedQuickUnionWithPathCompress(count);
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
